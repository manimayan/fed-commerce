import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Configuration } from "../app.constants";
import { Product } from '../model/product';
import { Observable, throwError } from 'rxjs';
import { retry, catchError } from 'rxjs/operators';


@Injectable()
export class ProductService {
    private rootUrl: string;
    constructor(private http: HttpClient, private config: Configuration) { 
        this.rootUrl = config.ServerWithApiUrl;
    }

    getProducts() : Observable<Product[]> {
    return this.http.get<Product[]>(this.rootUrl + 'product/getAll')
      .pipe(retry(1), catchError(this.handleError));
    }

    handleError(error: any) {
        let errorMessage = '';
        if (error.error instanceof ErrorEvent) {
          // Get client-side error
          errorMessage = error.error.message;
        } else {
          // Get server-side error
          errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
        }
        window.alert(errorMessage);
        return throwError(() => {
          return errorMessage;
        });
      }
}
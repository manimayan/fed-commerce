import { Component, OnInit } from '@angular/core';
import { BooksService } from './booksservice';
import { PrimeNGConfig } from 'primeng/api';

@Component({
  selector: 'app-books',
  templateUrl: './books.component.html',
  styleUrls: ['./books.component.scss']
})
export class BooksComponent implements OnInit {

  constructor(private bookService: BooksService, private primengConfig: PrimeNGConfig) { }

  ngOnInit() {}

  // loadProducts() {
  //   return this.bookService.getProducts().subscribe(data => {
  //     this.products = data;
  //     this.electronics = this.products.filter(res => res.category == 'electronics');
  //     this.books = this.products.filter(res => res.category == 'books');
  //     this.stationery = this.products.filter(res => res.category == 'stationery');
  //   });
  // }

}

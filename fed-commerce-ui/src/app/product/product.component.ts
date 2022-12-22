import { Component, OnInit } from '@angular/core';
import { ProductService } from './productservice';
import { Product } from '../model/product';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.scss']
})
export class ProductComponent implements OnInit {
  products: Product[] = [];
  electronics: Product[] = [];
  books: Product[] = [];
  stationery: Product[] = [];
  responsiveOptions;

  constructor(private productService: ProductService) {
    this.responsiveOptions = [
      {
        breakpoint: '1024px',
        numVisible: 3,
        numScroll: 3
      },
      {
        breakpoint: '768px',
        numVisible: 2,
        numScroll: 2
      },
      {
        breakpoint: '560px',
        numVisible: 1,
        numScroll: 1
      }
    ];
  }

  ngOnInit() {
    this.loadProducts();
  }

  loadProducts() {
    return this.productService.getProducts().subscribe(data => {
      this.products = data;
      this.electronics = this.products.filter(res => res.category == 'electronics');
      this.books = this.products.filter(res => res.category == 'books');
      this.stationery = this.products.filter(res => res.category == 'stationery');
    });
  }

}



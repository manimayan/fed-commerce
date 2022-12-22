import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';
import { Routes } from '@angular/router';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { Configuration } from './app.constants';
import { FormsModule } from '@angular/forms';
import { InputTextModule } from 'primeng/inputtext';
import { TabMenuModule } from 'primeng/tabmenu';
import { HttpClientModule } from '@angular/common/http';
import { CardModule } from 'primeng/card';
import { ButtonModule } from 'primeng/button';
import { TabViewModule } from 'primeng/tabview';
import { MessageService } from 'primeng/api';
import { CarouselModule } from 'primeng/carousel';
import { DataViewModule } from 'primeng/dataview';
import { CartComponent } from './cart/cart.component';
import { OrdersComponent } from './orders/orders.component';
import { ProductComponent } from './product/product.component';
import { ElectronicsComponent } from './product/electronics/electronics.component';
import { BooksComponent } from './product/books/books.component';
import { StationeryComponent } from './product/stationery/stationery.component';
import { ProductService } from './product/productservice';
import {RippleModule} from 'primeng/ripple';
import { BooksService } from './product/books/booksservice';

const routes: Routes = [
  {
    path: 'product',
    children: [
      { path: '', pathMatch: 'full', component: ProductComponent },
      { path: 'electronics', component: ElectronicsComponent },
      { path: 'stationery', component: StationeryComponent },
      { path: 'books', component: BooksComponent }
    ],
  },
  { path: '', redirectTo: '/product', pathMatch: 'full' },
  { path: 'cart', component: CartComponent },
  { path: 'orders', component: OrdersComponent },
]

@NgModule({
  declarations: [
    AppComponent,
    CartComponent,
    OrdersComponent,
    ElectronicsComponent,
    BooksComponent,
    StationeryComponent,
    ProductComponent
  ],
  imports: [
    HttpClientModule,
    FormsModule,
    InputTextModule,
    BrowserModule,
    BrowserAnimationsModule,
    TabMenuModule,
    CardModule,
    ButtonModule,
    TabViewModule,
    DataViewModule,
    CarouselModule,
    RippleModule,
    RouterModule.forRoot(routes),
  ],
  providers: [MessageService, ProductService, Configuration, BooksService],
  bootstrap: [AppComponent]

})
export class AppModule { }

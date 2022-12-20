import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';
import { Routes } from '@angular/router';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule } from '@angular/forms';
import { InputTextModule } from 'primeng/inputtext';
import { TabMenuModule } from 'primeng/tabmenu';
import { HttpClientModule } from '@angular/common/http';
import { TableModule } from 'primeng/table';
import { CardModule } from 'primeng/card';
import { ButtonModule } from 'primeng/button';
import { TabViewModule } from 'primeng/tabview';
import { ToastModule } from 'primeng/toast';
import { MessageService } from 'primeng/api';
import { DropdownModule } from 'primeng/dropdown';
import { FieldsetModule } from 'primeng/fieldset';
import { DialogModule } from 'primeng/dialog';
import { NgxSpinnerModule } from "ngx-spinner";
import { NgxSpinnerService } from "ngx-spinner";
import { CartComponent } from './cart/cart.component';
import { OrdersComponent } from './orders/orders.component';
import { ProductComponent } from './product/product.component';
import { ElectronicsComponent } from './product/electronics/electronics.component';
import { BooksComponent } from './product/books/books.component';
import { StationeryComponent } from './product/stationery/stationery.component';

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
    ProductComponent,
    ElectronicsComponent,
    BooksComponent,
    StationeryComponent
  ],
  imports: [
    HttpClientModule,
    FormsModule,
    InputTextModule,
    BrowserModule,
    BrowserAnimationsModule,
    TabMenuModule,
    TableModule,
    CardModule,
    ButtonModule,
    TabViewModule,
    ToastModule,
    DropdownModule,
    FieldsetModule,
    DialogModule,
    NgxSpinnerModule,
    RouterModule.forRoot(routes),
  ],
  providers: [MessageService, NgxSpinnerService],
  bootstrap: [AppComponent]

})
export class AppModule { }

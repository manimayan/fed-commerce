import { Component } from '@angular/core';
import { MessageService } from 'primeng/api';
import { NgxSpinnerService } from "ngx-spinner";
import { MenuItem } from 'primeng/api';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  public title = 'fed-commerce';
  items: MenuItem[];

  constructor(private spinner: NgxSpinnerService, private messageService: MessageService) {}

  ngOnInit() {
    this.loaditems();
  }

  loaditems() {
    this.items = [
      { label: 'Electronics', icon: 'pi pi-fw pi-home', routerLink: 'product/electronics' },
      { label: 'Stationery', icon: 'pi pi-fw pi-calendar',routerLink: 'product/stationery' },
      { label: 'Books', icon: 'pi pi-fw pi-pencil',routerLink: 'product/books' },
      { label: 'Home Improvement', icon: 'pi pi-fw pi-file' },
      { label: 'Grocery', icon: 'pi pi-fw pi-cog' }
    ];
  }
}

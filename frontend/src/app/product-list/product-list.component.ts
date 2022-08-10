import { Component, OnInit } from '@angular/core';
import {DataService} from "../data.service";
import {IProduct} from "../interfaces/IProduct";

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
  productList: Array<IProduct>;

  constructor(private dataService: DataService) {
    this.productList = dataService.productData
  }

  ngOnInit(): void {
  }

}

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
  selectedSort: String = ''

  constructor(private dataService: DataService) {
    this.productList = dataService.productData
  }

  ngOnInit(): void {
  }

  sort(selectedSort: String) {
    this.selectedSort = selectedSort
    this.productList = this.productList.sort(
      (a, b) => {
        if (selectedSort == 'least') {
          if (a.price > b.price) return 1
          if (a.price < b.price) return -1
          return 0
        }

        if(selectedSort == 'most') {
          if (a.price < b.price) return 1
          if (a.price > b.price) return -1
          return 0
        }

        if(selectedSort == 'onSale') {
          if (a.discontinued ) return -1
          if (!a.discontinued) return 1
          return 0
        }
        return 0
      }
    )
  }

}

import {Component, Input, OnInit} from '@angular/core';
import {IProduct} from "../interfaces/IProduct";
import {DataService} from "../data.service";

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  @Input() product!: IProduct
  constructor(private dataService: DataService) { }

  ngOnInit(): void {
  }

  addToCart() {
    this.dataService.addItemToCart(this.product)
  }
}

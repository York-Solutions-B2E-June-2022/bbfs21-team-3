import { Component, OnInit } from '@angular/core';
import {DataService} from "../data.service";
import {IProduct} from "../interfaces/IProduct";

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
  cartList: Array<IProduct>
  subtotal!: number
  tax: number = 0.07
  taxCost!: number
  sale!: number
  saleCost!: number
  shippingCost!: number
  total!: number

  constructor(private dataService: DataService) {
    this.cartList = this.dataService.getCart()
    this.dataService.cart$.subscribe((newCart) => {
      this.cartList = newCart
      this.subtotal = 0
      this.sale = 0
      this.shippingCost = 0
      for(let item of this.cartList) {
        this.subtotal += item.price
        this.sale = item.sale / 100
      }
      this.taxCost = this.subtotal * this.tax
      this.shippingCost = this.subtotal > 50 ? 0 : 5;
      this.total = this.subtotal + this.taxCost + this.shippingCost
      this.saleCost = Math.floor(this.total * this.sale)
      this.total -= this.saleCost
    })
  }
  
  ngOnInit(): void {
  }

}

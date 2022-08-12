import { Injectable } from '@angular/core';
import dummyData from '../assets/demoProducts.json';
import {IProduct} from "./interfaces/IProduct";
import {Subject} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class DataService {

  productData: Array<IProduct> = dummyData.products
  cart$ = new Subject<Array<IProduct>>()
  private cart: Array<IProduct> = []
  constructor() {
  }

  getCart() {
    return[...this.cart]
  }
  addItemToCart(item: IProduct) {
    this.cart.push(item)
    this.cart$.next(this.cart)
  }

  removeItemFromCart(item: IProduct) {
    const index = this.cart.findIndex((product) => {
      return product.name === product.name
    })

    if (index !== -1) {
      this.cart.splice(index, 1)
    }

    this.cart$.next(this.cart)
  }
}

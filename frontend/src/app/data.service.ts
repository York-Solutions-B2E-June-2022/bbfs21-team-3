import { Injectable } from '@angular/core';
import dummyData from '../assets/demoProducts.json';
import {IProduct} from "./interfaces/IProduct";

@Injectable({
  providedIn: 'root'
})
export class DataService {

  productData: Array<IProduct> = dummyData.products
  private cart: Array<IProduct> = []
  constructor() {
  }

  getCart() {
    return[...this.cart]
  }
  addItemToCart(item: IProduct) {
    if (this.cart.length < 10){
      this.cart.push(item)
    }

    console.log(this.cart)
  }
}

import { Injectable } from '@angular/core';
import dummyData from '../assets/demoProducts.json';
import {IProduct} from "./interfaces/IProduct";
import {IUser} from "./interfaces/IUser";
import {Subject} from "rxjs";
import { v4 as uuid } from 'uuid';


@Injectable({
  providedIn: 'root'
})
export class DataService {

  currentUser$ = new Subject<IUser | null>();

  productData: Array<IProduct> = dummyData.products
  private cart: Array<IProduct> = []
  userList: Array<IUser> = []

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

  onLogout() {
    this.currentUser$.next(null);
  }

  onLogin(username: string, password: string) {
    const foundUser = this.userList.find(u => u.username === username);
    if (foundUser && foundUser.password === password) {
      this.currentUser$.next(foundUser)
    }
  }
  createUser(username: string, password: string): string {
    if (!username || !password) {
      return "username and password cannot be blank"
    }

    if (username.length < 3 || password.length < 3) {
      return "username and password must be greater than 3 characters."
    }

    const foundUser = this.userList.find(u => u.username === username);
    if (foundUser) {
      return "username is taken"
    }

    const newUser: IUser = {
      id: uuid(),
      username: username,
      password: password
    }

    this.userList.push(newUser);
    console.log(this.userList)
    return "account created";
  }
}

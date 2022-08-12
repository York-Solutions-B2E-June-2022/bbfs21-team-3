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
  cart$ = new Subject<Array<IProduct>>()
  private cart: Array<IProduct> = []
  userList: Array<IUser> = []

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

  onLogout() {
    this.currentUser$.next(null);
  }

  onLogin(username: string, password: string) {
    const foundUser = this.userList.find(u => u.username === username);
    if (foundUser && foundUser.password === password) {
      this.currentUser$.next(foundUser)
    }
  }
  createUser(username: string, password: string, role: string): string {
    if (!username || !password || !role) {
      return "username, password, and/or role cannot be blank"
    }
    if (role !== "admin" && role !== "customer" && role !== "shopkeeper"){
      return "invalid role, please type in admin"
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
      password: password,
      role: role
    }

    this.userList.push(newUser);
    console.log(this.userList)
    return "account created";
  }
}

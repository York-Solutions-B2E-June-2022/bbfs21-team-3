import { Component, OnInit } from '@angular/core';
import {DataService} from "../data.service";


@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  username!:string
  password!:string
  result!: string

  constructor(private dataService: DataService) { }

  ngOnInit(): void {
  }

  // OnClick() {
  //   this.dataService.onLogin(this.username, this.password)
  //   console.log("login button works")
  //   console.log(this.username, this.password)
  // }

  // onRegister() {
  //   this.result = this.dataService.createUser(this.username, this.password);
  //   console.log("register button works")
  //   console.log(this.username, this.password)
  // }

  logOut(){
    this.dataService.onLogout()
  }
}

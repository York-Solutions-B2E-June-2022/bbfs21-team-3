import { Component, OnInit } from '@angular/core';
import {DataService} from "../data.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  username!: string;
  password!: string;

  constructor(private dataService: DataService) { }

  ngOnInit(): void {
  }


  onClick() {
    this.dataService.onLogin(this.username, this.password)
    console.log("login button works")
    console.log(this.username, this.password)
  }
}

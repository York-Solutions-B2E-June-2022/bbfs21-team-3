import { Component } from '@angular/core';
import {DataService} from "./data.service";
import {IUser} from "./interfaces/IUser";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'frontend';
  currentUser: IUser | null = null;


  constructor(private dataService: DataService) {
    this.dataService.currentUser$.subscribe(nextValue =>  this.currentUser = nextValue)
  }
  onLogout() {
    this.dataService.onLogout();
  }
}

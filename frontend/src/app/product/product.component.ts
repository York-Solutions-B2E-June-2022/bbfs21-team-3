import {Component, Input, OnInit} from '@angular/core';
import {DataService} from "../data.service";

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {
  @Input() product: any;
  @Input() inCart: boolean = false;

  constructor(private dataService: DataService) { }

  ngOnInit(): void {
  }

  addToCart() {
//function will be created in data service
  }

  updateCartCount($event: any) {
//function will be created in data service
  }
}

import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-form-volontari',
  templateUrl: './form-volontari.component.html',
  styleUrls: ['./form-volontari.component.scss'],
})
export class FormVolontariComponent implements OnInit {

  showMainContent: boolean = true;
  constructor() { }

  ngOnInit() {}

ShowHideButton(){
  this.showMainContent = this.showMainContent ? false : true;
}

}

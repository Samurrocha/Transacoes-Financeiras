import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';

@Component({
  selector: 'app-transaction-delete',
  standalone: true,
  imports: [CommonModule,HttpClientModule],
  templateUrl: './transaction-delete.component.html',
  styleUrl: './transaction-delete.component.css'
})
export class TransactionDeleteComponent {

  selectedTransactionId : number|null = 0
  

  transactions=[
    {id:0,amount:9565,description:"aaaaaa"},
    {id:1,amount:75,description:"bbbbbbb"},
    {id:2,amount:4565,description:"ccccccccc"},
    {id:3,amount:465,description:"ddddddddd"},
    {id:4,amount:65,description:"eeeeeeeee"}
  ]




  deleteTransaction() { }
}

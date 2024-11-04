import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
//import { TransactionComponent } from './components/transactionRegister/transaction.component';
import { TransactionListComponent } from './components/transaction-read/transaction-list.component';
//import { TransactionEditComponent } from './components/transaction-edit/transaction-edit.component';
//import { TransactionDeleteComponent } from './components/transaction-delete/transaction-delete.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    RouterOutlet,
    //TransactionComponent,
    TransactionListComponent,
   // TransactionEditComponent,
    //TransactionDeleteComponent
  ],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'frontEnd';

}

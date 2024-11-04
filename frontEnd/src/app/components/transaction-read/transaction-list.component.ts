import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Transaction } from '../../models/Transaction.model';
import { TransactionService } from '../../services/transaction.service';
import { provideHttpClient, withFetch } from '@angular/common/http';

@Component({
  selector: 'app-transaction-list',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './transaction-list.component.html',
  styleUrl: './transaction-list.component.css',
  providers: [TransactionService]
})

export class TransactionListComponent {

  transactions: Transaction[] = [];

  selectedType: string = 'Todos';

  constructor(private transactionService: TransactionService) { this.readTransactions() }


  readTransactions() {
    this.transactionService.listTransactions().subscribe(response => {
      this.transactions = response; // Acessa o primeiro array
    });
  }

  filterTransactions() {

    if (this.selectedType == "Todos") {
      this.readTransactions();
      
    }else{

    console.log(this.selectedType)
    this.transactionService.listFilterTransactions(this.selectedType).subscribe(response => {
      this.transactions = response;
    })

  }
}






  // private apiUrl = 'http://localhost:8080/api/transactions'; // URL da sua API
}

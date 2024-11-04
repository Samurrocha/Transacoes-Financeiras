import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Transaction } from '../models/Transaction.model';

@Injectable({ providedIn: 'root' })
export class TransactionService {

  private apiUrl = 'http://localhost:8080';

  constructor(private http: HttpClient) { }


  // createTransaction(Transaction: Transaction): Observable<Transaction> {
  //   return this.http.post<Transaction>(this.apiUrl, Transaction);
  // }

  listTransactions(): Observable<Transaction[]> {
    return this.http.get<Transaction[]>(this.apiUrl);
  }

  listFilterTransactions(type: string): Observable<Transaction[]> {
    return this.http.get<Transaction[]>(`${this.apiUrl}/filtered?type=${encodeURIComponent(type)}`);
  }


}



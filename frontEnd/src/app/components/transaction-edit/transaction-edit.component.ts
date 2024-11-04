import { Component } from '@angular/core';
import { FormGroup, FormControl, ReactiveFormsModule, Validators, FormsModule } from '@angular/forms';

@Component({
  selector: 'app-transaction-edit',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './transaction-edit.component.html',
  styleUrl: './transaction-edit.component.css'
})
export class TransactionEditComponent {


  transactionForm = new FormGroup({

    type: new FormControl(""),
    description: new FormControl(""),
    amount:new FormControl<number|null>(null),
    category:new FormControl(""),
    date:new FormControl<Date|null>(null)
  })

  onSubmit(){}

}

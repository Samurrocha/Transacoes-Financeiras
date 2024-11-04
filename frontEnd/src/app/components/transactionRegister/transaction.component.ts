import { Component } from '@angular/core';
import { FormGroup, FormControl, ReactiveFormsModule, Validators } from '@angular/forms';


@Component({
  selector: 'app-transaction',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './transaction.component.html',
  styleUrl: './transaction.component.css'
})
export class TransactionComponent {

  transacaoForm = new FormGroup({
    tipo: new FormControl('', Validators.required), // Receita ou Despesa
    valor: new FormControl<number | null>(null, [Validators.required, Validators.min(0)]), // Valor do tipo número, inicializando com null
    categoria: new FormControl('', Validators.required), // Categoria da transação
    description: new FormControl('') // Descrição (opcional)
  });


  onSubmit() {
    
    if (this.transacaoForm.valid) {
      console.log("deu bom!!")

      if (this.transacaoForm.value.tipo == "despesa") {
        let valor = this.transacaoForm.value.valor ? this.transacaoForm.value.valor * -1 : null
        console.log(valor)
      }
    }


  }




  atualizarValorNegativo() {

    this.transacaoForm.get("tipo")?.valueChanges.subscribe((value) => {
      if (value == "despesa") {
        console.log(34342)
        if (this.transacaoForm.value.valor) {

          console.log(this.transacaoForm.value.valor * -1)
        }
      }


    })
  }
}

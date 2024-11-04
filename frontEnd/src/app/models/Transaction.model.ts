export enum TransactionType {
    Receita = 'Receita',
    Despesa = 'Despesa'
  }
  
  export interface Transaction {
    id: number;
    valor: number;
    data: Date;
    description: string;
    categoria: number| String; // ou categoria: Category se você quiser incluir a categoria inteira
    type: TransactionType;
  }
  
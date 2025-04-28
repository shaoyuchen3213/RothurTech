import { Component, OnInit } from '@angular/core';
import { Product } from '../product';
import { CommonModule } from '@angular/common';
import { ApiService } from '../api.service';
import {FormsModule} from '@angular/forms'
@Component({
  selector: 'app-product-list',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './product-list.component.html',
  styleUrl: './product-list.component.css'
})

export class ProductListComponent implements OnInit{
  products: Product[] = [];
  selectedProduct ? : Product;
  isEditing = false;
  isAdd = false;
  
  newProduct: Product = {
    id : 0,
    productName : '',
    price : 0,
    category : '',
    quantity : 0,
    descrption  : ''
  }

  constructor (private api: ApiService) {}
  ngOnInit(){
    this.loadAll();
  }
  loadAll() {
    this.api.getProducts().subscribe(data => {
      this.products = data;
    });
  }
  viewPorduct(id : number) {
    this.api.getProduct(id)
      .subscribe(data => this.selectedProduct = data)
  }
  closeView() {
    this.selectedProduct = undefined
  }
  editProduct() {
    this.isEditing = true;
  }
  delete(id:number) {
    if(!confirm("Remove this record")) return;
    this.api.delete(id).subscribe(() => {
      if(this.selectedProduct?.id === id) {
        this.closeView();
      }
      this.loadAll();
    });
  }
  save() {
    if(!this.selectedProduct) return;
    this.api.updateProduct(this.selectedProduct).subscribe(updated => {
      this.selectedProduct = updated;
      this.isEditing = false;
      this.loadAll();
    })
  }
  cancelEdit() {
    if(this.selectedProduct) {
      this.viewPorduct(this.selectedProduct.id);
    }
    this.isEditing = false;
    this.isAdd = false;
  }

  clickOnAdd() {
    this.isAdd = true;
  }
  addProduct() {
    if (!this.newProduct.productName) {
      alert('Please enter Product Name');
      return;
    }
    this.api.addProduct(this.newProduct).subscribe(created => {
      this.products.unshift(created);
    })
    this.newProduct = {
      id : 0,
    productName : '',
    price : 0,
    category : '',
    quantity : 0,
    descrption  : ''
    }
    this.isAdd = false;
  }
}

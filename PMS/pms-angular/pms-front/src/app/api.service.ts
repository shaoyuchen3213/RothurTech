import { Injectable } from "@angular/core";
import { HttpClient, HttpParams } from "@angular/common/http";
import { Observable } from "rxjs";
import { Product } from "./product";

@Injectable ({providedIn: 'root'})
export class ApiService {
    private baseURL = "http://localhost:8080/api/product";
    constructor(private http: HttpClient) {}


    /*Get all product*/
    getProducts(): Observable<Product[]> {
        return this.http.get<Product[]>(this.baseURL)
    }
    
    //get product detail
    getProduct(id: number): Observable<Product> {
        return this.http.get<Product>(`${this.baseURL}/${id}`);
    }

    //update product
    updateProduct(product: Product) : Observable<Product> {
        return this.http.put<Product>(`${this.baseURL}/${product.id}`, product)
    }
    //delete product
    delete(id : number) : Observable<string> {
        return this.http.delete(`${this.baseURL}/${id}`, {responseType: 'text'})
    }
    //add Product
    addProduct(product: Product) : Observable<Product> {
        return this.http.post<Product>(`${this.baseURL}`, product)
    }
}


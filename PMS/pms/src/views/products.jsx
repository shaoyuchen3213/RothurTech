import React, {useEffect, useState} from "react";
import axios from "axios";
export default function Products() {
    const[products, setProducts] = useState([]);
    const[click, setCLick] = useState(false);
    const newProduct = {
        "productName": "",
        "price": 0,
        "category": "",
        "quantity": 0,
        "description": ""
    }

    useEffect(()=> {
        axios.get("http://localhost:8080/api/product").then(response => setProducts(response.data)).catch(err => console.log(err));
    }, [products]);

    function handleClick() {
        setCLick(true);
    }

    function handleSubmit(newProduct) {
        console.log(newProduct);
    }
    function handleCancel() {
        setCLick(false)
    }

    return(
        <div>
            <table>
                <thead>
                <tr>
                    <th scope="col">ProductName</th>
                    <th scope="col">Price</th>
                    <th scope="col">Category</th>
                    <th scope="col">Quantity</th>
                    <th scope="col">Description</th>
                </tr>
                </thead>
                <tbody>
                {products.map((product, i) => {
                    return (
                <tr key={i}>

                    <th scope="row"> {product.productName}</th>
                    <th scope="row"> {product.price}</th>
                    <th scope="row"> {product.category}</th>
                    <th scope="row"> {product.quantity}</th>
                    <th scope="row"> {product.description}</th>

                </tr>)
                })}
                {click ?(<tr>

                    <th scope="row"> <input type="text" name = {newProduct.productName}></input></th>
                    <th scope="row"> <input type="number" name = {newProduct.price}></input></th>
                    <th scope="row"> <input type="text" name = {newProduct.category}></input></th>
                    <th scope="row"> <input type="number" name = {newProduct.quantity}></input></th>
                    <th scope="row"><input type="text" name = {newProduct.description}></input> </th>
                        <th>
                            <button onClick={handleSubmit(newProduct)}> Submit</button>
                            <button onClick={handleCancel}> Cancel</button>
                        </th>
                    </tr>
                    ) :" "}

                </tbody>
            </table>
            <button onClick={handleClick}>ADD Product</button>
        </div>
    )
}
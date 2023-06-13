import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { AddData } from '../services/api';
import { BackBtn } from '../Componentes/Buttons';
import AuthCheck from './Auth/AuthCheck';

export default function AddProduct() {
    const navigate = useNavigate();
    const [product, setProduct] = useState({
        custname: '',
        productId: '',
        lefteye: '',
        righteye: '',
        type: '',
    });

    const handleInputChange = (e) => {
        const { name, value } = e.target;
        setProduct((prevState) => ({
            ...prevState,
            [name]: value,
        }));
    };

    const handleSubmit = async (e) => {
        e.preventDefault();

        try {
            await AddData(product);
            alert('Product added!');
            navigate('/dashboard');
        } catch (error) {
            console.error(error);
        }
    };

    return (
        <div className='dashboard-content'>
            <AuthCheck/>
            <div className='cardx form-data-align'>
                <form onSubmit={handleSubmit} className='form-data-card '>
                    <input type='text' placeholder='Customer' name='custname' value={product.custname} onChange={handleInputChange} className='product-input' required/>
                    <input type='number' placeholder='ProductID' name='productid' value={product.productid} onChange={handleInputChange} className='product-input' required />
                    <input type='number' placeholder='Lefteye' name='lefteye' value={product.lefteye} onChange={handleInputChange} className='product-input' required />
                    <input type='number' placeholder='righteye' name='righteye' value={product.righteye} onChange={handleInputChange} className='product-input' required />
                    {/* <input type='text' placeholder='type' name='type' value={product.type} onChange={handleInputChange} className='product-input' required /> */}
                    <button type='submit' className='button2'>Add Customer</button>
                </form>
            </div>
        
        </div>
    );
}

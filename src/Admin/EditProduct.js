import React, { useState, useEffect } from 'react';
import { useParams, useNavigate } from 'react-router-dom';
import { EditData, FindData } from '../services/api';
import { BackBtn } from '../Componentes/Buttons';
import AuthCheck from './Auth/AuthCheck';

export default function EditProduct() {
    const { productId } = useParams();
    const navigate = useNavigate();
    const [product, setProduct] = useState({
        custname: '',
        productId: '',
        lefteye: '',
        righteye: '',
        type: '',
    });

    useEffect(() => {
        fetchProduct();
    }, []);

    const fetchProduct = async () => {
        try {
            const response = await FindData(productId);
            setProduct(response.data);
            console.log(response.data);
        } catch (error) {
            console.error(error);
        }
    };

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
            await EditData(productId, product);
            alert('Product updated !');
            navigate('/dashboard');
        } catch (error) {
            console.error(error);
        }
    };

    return (
        <div className='dashboard-content'>
            <AuthCheck/>
            <div className='cardx form-data-align'>
                <form onSubmit={handleSubmit} className='form-data-card'>
                    <label>Customer Name</label>
                    <input type='text' placeholder='Customer Name' name='custname' value={product.custname} onChange={handleInputChange} className='product-input' required />
                    <label>Product Id</label>
                    <input type='number' placeholder='ProductId' name='productid' value={product.productId} onChange={handleInputChange} className='product-input' required />
                    <label>Power in Lefteye</label>
                    <input type='number' placeholder='Lefteye' name='lefteye' value={product.lefteye} onChange={handleInputChange} className='product-input' required />
                    <label>Power in Righteye</label>
                    <input type='number' placeholder='Righteye' name='righteye' value={product.righteye} onChange={handleInputChange} className='product-input' required />
                    <label>Type</label>
                    {/* <input type='text' placeholder='Img URL' name='type' value={product.type} onChange={handleInputChange} className='product-input' required /> */}
                    <button type='submit' className='button2'>Update Product</button>
                </form>
            </div>
            
        </div>
    );
}

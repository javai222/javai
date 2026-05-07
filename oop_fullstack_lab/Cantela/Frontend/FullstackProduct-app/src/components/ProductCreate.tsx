import { useState } from 'react';
import type { Product } from '../types/Product';
import { createProduct } from '../api/ProductService';
import './ProductCreate.css';

export default function ProductCreate({ onCreated }: { onCreated?: () => void }) {
  const [form, setForm] = useState<Omit<Product, 'id'>>({
    name: '',
    price: 0,
    description: '',
    quantity: 0,
  });
  const [submitting, setSubmitting] = useState(false);
  const [message, setMessage] = useState<{ text: string; type: 'success' | 'error' } | null>(null);

  const handleChange = (field: keyof Omit<Product, 'id'>, value: string) => {
    setForm((prev) => ({
      ...prev,
      [field]: field === 'price' ? parseFloat(value) || 0 : field === 'quantity' ? parseInt(value) || 0 : value,
    }));
  };

  const handleSubmit = async (e: React.FormEvent<HTMLFormElement>) => {
    e.preventDefault();
    if (!form.name || form.price <= 0) {
      setMessage({ text: 'Name and a valid price are required.', type: 'error' });
      return;
    }
    try {
      setSubmitting(true);
      setMessage(null);
      await createProduct(form);
      setMessage({ text: 'Product created successfully!', type: 'success' });
      setForm({ name: '', price: 0, description: '', quantity: 0 });
      onCreated?.();
    } catch {
      setMessage({ text: 'Failed to create product. Please try again.', type: 'error' });
    } finally {
      setSubmitting(false);
    }
  };

  return (
    <section className="product-create">
      <h2 className="create-title">Add New Product</h2>
      <form className="create-form" onSubmit={handleSubmit}>
        <div className="form-group">
          <label htmlFor="name">Name</label>
          <input
            id="name"
            type="text"
            placeholder="Product name"
            value={form.name}
            onChange={(e) => handleChange('name', e.target.value)}
            required
          />
        </div>
        <div className="form-row">
          <div className="form-group">
            <label htmlFor="price">Price ($)</label>
            <input
              id="price"
              type="number"
              step="0.01"
              min="0.01"
              placeholder="0.00"
              value={form.price || ''}
              onChange={(e) => handleChange('price', e.target.value)}
              required
            />
          </div>
          <div className="form-group">
            <label htmlFor="quantity">Quantity</label>
            <input
              id="quantity"
              type="number"
              min="0"
              placeholder="0"
              value={form.quantity ?? ''}
              onChange={(e) => handleChange('quantity', e.target.value)}
            />
          </div>
        </div>
        <div className="form-group">
          <label htmlFor="description">Description</label>
          <textarea
            id="description"
            placeholder="Product description"
            value={form.description}
            onChange={(e) => handleChange('description', e.target.value)}
            rows={3}
          />
        </div>
        {message && (
          <p className={`form-message ${message.type}`}>{message.text}</p>
        )}
        <button type="submit" className="submit-btn" disabled={submitting}>
          {submitting ? 'Creating...' : 'Create Product'}
        </button>
      </form>
    </section>
  );
}

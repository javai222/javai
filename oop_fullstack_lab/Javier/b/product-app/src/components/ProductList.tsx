// src/components/ProductList.tsx
import { useState, useMemo, useEffect } from "react";
import { getProducts, deleteProduct, updateProduct } from "../api/productService";
import type { Product, UpdateProductPayload } from "../api/productService";

const PALETTE = [
    { bg: "#FFF0E6", text: "#C2470A", dot: "#F4845F" },
    { bg: "#E8F4FD", text: "#0B5394", dot: "#4A9FD5" },
    { bg: "#EDF7EE", text: "#1A6B2E", dot: "#52B26B" },
    { bg: "#F3EEFF", text: "#5B21B6", dot: "#9B72E8" },
    { bg: "#FFF5E6", text: "#92400E", dot: "#F59E0B" },
    { bg: "#FCE8EE", text: "#9B1239", dot: "#F472A8" },
];

const getInitials = (p: Product) => p.name.slice(0, 2).toUpperCase();
const getPalette = (idx: number) => PALETTE[idx % PALETTE.length];

const styles = `
  @import url('https://fonts.googleapis.com/css2?family=Cormorant+Garamond:wght@300;400;500;600&family=DM+Mono:wght@300;400&family=DM+Sans:wght@300;400;500&display=swap');

  * { box-sizing: border-box; }

  .pl-root {
    font-family: 'DM Sans', sans-serif;
    padding: 2.5rem 0 3rem;
    min-height: 100vh;
    background: #FAFAF8;
    color: #1A1A1A;
  }

  .pl-header {
    display: flex;
    align-items: flex-end;
    justify-content: space-between;
    margin-bottom: 2.25rem;
    padding-bottom: 1.5rem;
    border-bottom: 1px solid #E8E8E4;
  }

  .pl-title {
    font-family: 'Cormorant Garamond', serif;
    font-weight: 300;
    font-size: 44px;
    letter-spacing: -0.5px;
    margin: 0 0 2px;
    line-height: 1;
    color: #0D0D0D;
  }

  .pl-subtitle {
    font-size: 12px;
    color: #999;
    margin: 0;
    letter-spacing: 0.08em;
    text-transform: uppercase;
    font-weight: 400;
  }

  .pl-count {
    font-family: 'DM Mono', monospace;
    font-size: 11px;
    color: #AAA;
    letter-spacing: 0.05em;
    padding: 4px 10px;
    border: 1px solid #E0E0DA;
    border-radius: 99px;
    background: #fff;
  }

  .pl-controls {
    display: flex;
    gap: 10px;
    margin-bottom: 2rem;
  }

  .pl-search {
    flex: 1;
    height: 40px;
    padding: 0 14px;
    border: 1px solid #E0E0DA;
    border-radius: 10px;
    font-size: 13px;
    font-family: 'DM Sans', sans-serif;
    background: #fff;
    color: #1A1A1A;
    outline: none;
    transition: border-color 0.2s, box-shadow 0.2s;
  }
  .pl-search:focus {
    border-color: #B5B5AF;
    box-shadow: 0 0 0 3px rgba(0,0,0,0.04);
  }
  .pl-search::placeholder { color: #C4C4BC; }

  .pl-select {
    height: 40px;
    padding: 0 12px;
    border: 1px solid #E0E0DA;
    border-radius: 10px;
    font-size: 13px;
    font-family: 'DM Sans', sans-serif;
    background: #fff;
    color: #1A1A1A;
    outline: none;
    cursor: pointer;
    appearance: none;
    -webkit-appearance: none;
    padding-right: 32px;
    background-image: url("data:image/svg+xml,%3Csvg xmlns='http://www.w3.org/2000/svg' width='12' height='8' fill='none'%3E%3Cpath d='M1 1l5 5 5-5' stroke='%23999' stroke-width='1.5' stroke-linecap='round' stroke-linejoin='round'/%3E%3C/svg%3E");
    background-repeat: no-repeat;
    background-position: right 10px center;
    transition: border-color 0.2s;
  }
  .pl-select:focus { border-color: #B5B5AF; }

  .pl-grid {
    display: grid;
    grid-template-columns: repeat(auto-fill, minmax(220px, 1fr));
    gap: 14px;
  }

  .pl-card {
    background: #fff;
    border: 1px solid #EAEAE6;
    border-radius: 16px;
    padding: 1.25rem;
    display: flex;
    flex-direction: column;
    gap: 0;
    transition: transform 0.18s cubic-bezier(.34,1.56,.64,1), box-shadow 0.18s ease, border-color 0.18s;
    cursor: default;
    position: relative;
    overflow: hidden;
  }
  .pl-card::before {
    content: '';
    position: absolute;
    top: 0; left: 0; right: 0;
    height: 3px;
    background: var(--card-dot);
    opacity: 0;
    transition: opacity 0.2s;
  }
  .pl-card:hover {
    transform: translateY(-3px);
    box-shadow: 0 12px 40px rgba(0,0,0,0.07), 0 2px 8px rgba(0,0,0,0.04);
    border-color: #DEDED8;
  }
  .pl-card:hover::before { opacity: 1; }

  .pl-card-actions {
    position: absolute;
    top: 10px; right: 10px;
    display: flex;
    gap: 4px;
    opacity: 0;
    transition: opacity 0.15s;
  }
  .pl-card:hover .pl-card-actions { opacity: 1; }

  .pl-btn-edit, .pl-btn-delete {
    width: 28px; height: 28px;
    border-radius: 8px;
    border: 1px solid transparent;
    cursor: pointer;
    font-size: 12px;
    display: flex; align-items: center; justify-content: center;
    transition: background 0.15s, border-color 0.15s;
  }
  .pl-btn-edit {
    background: #F5F5F2;
    border-color: #E4E4DF;
    color: #666;
  }
  .pl-btn-edit:hover { background: #EAEAE6; }
  .pl-btn-delete {
    background: #FFF2F2;
    border-color: #FCD4D4;
    color: #C53030;
  }
  .pl-btn-delete:hover { background: #FFE4E4; }

  .pl-avatar {
    width: 44px; height: 44px;
    border-radius: 12px;
    display: flex; align-items: center; justify-content: center;
    font-family: 'DM Mono', monospace;
    font-weight: 400;
    font-size: 14px;
    margin-bottom: 14px;
    letter-spacing: 0.05em;
  }

  .pl-product-name {
    margin: 0 0 3px;
    font-weight: 500;
    font-size: 14px;
    white-space: nowrap;
    overflow: hidden;
    text-overflow: ellipsis;
    color: #111;
  }

  .pl-product-id {
    font-family: 'DM Mono', monospace;
    font-size: 10px;
    color: #C4C4BC;
    margin: 0 0 12px;
    letter-spacing: 0.06em;
  }

  .pl-tags {
    display: flex;
    flex-wrap: wrap;
    gap: 5px;
    margin-bottom: 12px;
  }

  .pl-tag {
    font-size: 11px;
    padding: 3px 9px;
    border-radius: 99px;
    font-weight: 400;
    letter-spacing: 0.02em;
  }

  .pl-divider {
    border: none;
    border-top: 1px solid #F0F0EC;
    margin: 0 0 10px;
  }

  .pl-description {
    font-size: 11px;
    color: #B0B0A8;
    margin: 0;
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
    line-height: 1.5;
  }

  .pl-empty {
    text-align: center;
    padding: 5rem 0;
    color: #C4C4BC;
    font-size: 13px;
    letter-spacing: 0.04em;
  }

  /* Modal */
  .pl-overlay {
    position: fixed; inset: 0;
    background: rgba(10,10,8,0.35);
    backdrop-filter: blur(4px);
    display: flex; align-items: center; justify-content: center;
    z-index: 999;
    animation: overlayIn 0.15s ease;
  }
  @keyframes overlayIn { from { opacity: 0 } to { opacity: 1 } }

  .pl-modal {
    background: #fff;
    border-radius: 20px;
    padding: 2rem;
    width: 380px;
    box-shadow: 0 24px 60px rgba(0,0,0,0.14), 0 4px 12px rgba(0,0,0,0.06);
    animation: modalIn 0.2s cubic-bezier(.34,1.56,.64,1);
  }
  @keyframes modalIn { from { opacity: 0; transform: scale(0.95) translateY(8px) } to { opacity: 1; transform: scale(1) translateY(0) } }

  .pl-modal-title {
    font-family: 'Cormorant Garamond', serif;
    font-weight: 400;
    font-size: 26px;
    margin: 0 0 1.5rem;
    color: #0D0D0D;
  }

  .pl-field { display: flex; flex-direction: column; gap: 5px; }
  .pl-label { font-size: 11px; color: #999; letter-spacing: 0.07em; text-transform: uppercase; font-weight: 400; }
  .pl-input {
    width: 100%; padding: 8px 12px;
    border: 1px solid #E0E0DA; border-radius: 10px;
    font-size: 13px; font-family: 'DM Sans', sans-serif;
    color: #1A1A1A; background: #FAFAF8;
    outline: none; transition: border-color 0.2s, box-shadow 0.2s;
  }
  .pl-input:focus {
    border-color: #B5B5AF;
    box-shadow: 0 0 0 3px rgba(0,0,0,0.04);
    background: #fff;
  }

  .pl-modal-actions {
    display: flex; gap: 8px;
    margin-top: 1.5rem; justify-content: flex-end;
  }

  .pl-btn-cancel {
    padding: 8px 18px; border-radius: 10px;
    border: 1px solid #E0E0DA; background: transparent;
    font-size: 13px; font-family: 'DM Sans', sans-serif;
    cursor: pointer; color: #666;
    transition: background 0.15s;
  }
  .pl-btn-cancel:hover { background: #F5F5F2; }

  .pl-btn-save {
    padding: 8px 20px; border-radius: 10px;
    border: none; background: #111;
    font-size: 13px; font-family: 'DM Sans', sans-serif;
    color: #fff; cursor: pointer; font-weight: 500;
    transition: background 0.15s, transform 0.1s;
  }
  .pl-btn-save:hover { background: #2A2A2A; }
  .pl-btn-save:active { transform: scale(0.98); }
`;

interface ProductCardProps {
    product: Product;
    colorIdx: number;
    onDelete: (id: number) => void;
    onEdit: (product: Product) => void;
}

const ProductCard = ({ product, colorIdx, onDelete, onEdit }: ProductCardProps) => {
    const pal = getPalette(colorIdx);

    return (
        <div
            className="pl-card"
            style={{ "--card-dot": pal.dot } as React.CSSProperties}
        >
            <div className="pl-card-actions">
                <button className="pl-btn-edit" onClick={() => onEdit(product)} title="Edit">✏️</button>
                <button className="pl-btn-delete" onClick={() => onDelete(product.id)} title="Delete">✕</button>
            </div>

            <div
                className="pl-avatar"
                style={{ background: pal.bg, color: pal.text }}
            >
                {getInitials(product)}
            </div>

            <p className="pl-product-name">{product.name}</p>
            <p className="pl-product-id">ID #{product.id}</p>

            <div className="pl-tags">
                <span className="pl-tag" style={{ background: "#F0F7FF", color: "#1A5FAD" }}>
                    ₱{product.price.toFixed(2)}
                </span>
                <span className="pl-tag" style={{ background: "#F3EEFF", color: "#5B21B6" }}>
                    {product.category}
                </span>
                <span className="pl-tag" style={{ background: product.stock > 10 ? "#EDF7EE" : "#FFF5E6", color: product.stock > 10 ? "#1A6B2E" : "#92400E" }}>
                    {product.stock} in stock
                </span>
            </div>

            <hr className="pl-divider" />
            <p className="pl-description">{product.description}</p>
        </div>
    );
};

interface EditModalProps {
    product: Product;
    onClose: () => void;
    onSave: (updated: Product) => void;
}

const EditModal = ({ product, onClose, onSave }: EditModalProps) => {
    const [form, setForm] = useState<Product>({ ...product });
    const handleChange = (field: keyof Product, value: string | number) =>
        setForm(prev => ({ ...prev, [field]: value }));

    const handleSave = async () => {
        try {
            const payload: UpdateProductPayload = {
                name: form.name, category: form.category,
                description: form.description, price: form.price, stock: form.stock,
            };
            await updateProduct(form.id, payload);
            onSave(form);
        } catch (err) {
            console.error(err);
            alert("Failed to update product.");
        }
    };

    const fields: { key: keyof Product; label: string; type?: string }[] = [
        { key: "name", label: "Product Name" },
        { key: "category", label: "Category" },
        { key: "description", label: "Description" },
        { key: "price", label: "Price", type: "number" },
        { key: "stock", label: "Stock", type: "number" },
    ];

    return (
        <div className="pl-overlay" onClick={onClose}>
            <div className="pl-modal" onClick={e => e.stopPropagation()}>
                <h2 className="pl-modal-title">Edit Product</h2>
                <div style={{ display: "flex", flexDirection: "column", gap: 12 }}>
                    {fields.map(({ key, label, type }) => (
                        <div key={key} className="pl-field">
                            <label className="pl-label">{label}</label>
                            <input
                                className="pl-input"
                                type={type || "text"}
                                value={form[key] as string | number}
                                onChange={e => handleChange(key, type === "number"
                                    ? (key === "stock" ? parseInt(e.target.value) : parseFloat(e.target.value))
                                    : e.target.value
                                )}
                            />
                        </div>
                    ))}
                </div>
                <div className="pl-modal-actions">
                    <button className="pl-btn-cancel" onClick={onClose}>Cancel</button>
                    <button className="pl-btn-save" onClick={handleSave}>Save changes</button>
                </div>
            </div>
        </div>
    );
};

export const ProductList = () => {
    const [products, setProducts] = useState<Product[]>([]);
    const [search, setSearch] = useState("");
    const [categoryFilter, setCategoryFilter] = useState("");
    const [editingProduct, setEditingProduct] = useState<Product | null>(null);

    useEffect(() => {
        getProducts()
            .then((data: any) => setProducts(data))
            .catch(console.error);
    }, []);

    const handleDelete = async (id: number) => {
        if (!confirm("Delete this product?")) return;
        try {
            await deleteProduct(id);
            setProducts(prev => prev.filter(p => p.id !== id));
        } catch (err) {
            alert("Failed to delete product.");
        }
    };

    const handleEditSave = (updated: Product) => {
        setProducts(prev => prev.map(p => p.id === updated.id ? updated : p));
        setEditingProduct(null);
    };

    const categories = useMemo(() =>
        [...new Set(products.map(p => p.category))].sort(), [products]);

    const filtered = useMemo(() => products.filter(p => {
        const q = search.toLowerCase();
        const matchSearch = !q || p.name.toLowerCase().includes(q) || String(p.id).includes(q);
        const matchCategory = !categoryFilter || p.category === categoryFilter;
        return matchSearch && matchCategory;
    }), [products, search, categoryFilter]);

    return (
        <>
            <style>{styles}</style>
            <div className="pl-root">
                {editingProduct && (
                    <EditModal product={editingProduct} onClose={() => setEditingProduct(null)} onSave={handleEditSave} />
                )}

                <div className="pl-header">
                    <div>
                        <h1 className="pl-title">Products</h1>
                        <p className="pl-subtitle">Product Catalog</p>
                    </div>
                    <span className="pl-count">
                        {filtered.length} item{filtered.length !== 1 ? "s" : ""}
                    </span>
                </div>

                <div className="pl-controls">
                    <input
                        type="text"
                        className="pl-search"
                        placeholder="Search by name or ID…"
                        value={search}
                        onChange={e => setSearch(e.target.value)}
                    />
                    <select
                        className="pl-select"
                        value={categoryFilter}
                        onChange={e => setCategoryFilter(e.target.value)}
                    >
                        <option value="">All categories</option>
                        {categories.map(c => <option key={c} value={c}>{c}</option>)}
                    </select>
                </div>

                {filtered.length === 0 ? (
                    <div className="pl-empty">No products match your search.</div>
                ) : (
                    <div className="pl-grid">
                        {filtered.map((product, idx) => (
                            <ProductCard
                                key={product.id}
                                product={product}
                                colorIdx={idx}
                                onDelete={handleDelete}
                                onEdit={setEditingProduct}
                            />
                        ))}
                    </div>
                )}
            </div>
        </>
    );
};

export default ProductList;
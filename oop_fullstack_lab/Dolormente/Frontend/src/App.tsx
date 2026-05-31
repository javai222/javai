import { useEffect, useState } from "react";
import axios from "axios";

type Product = {
    id: number;
    name: string;
    price: number;
    quantity: number;
};

const BASE_URL = "http://localhost:8080/products";

export default function App() {
    const [products, setProducts] = useState<Product[]>([]);
    const [loading, setLoading] = useState(false);
    const [error, setError] = useState("");

    const [open, setOpen] = useState(false);
    const [search, setSearch] = useState("");

    const [name, setName] = useState("");
    const [price, setPrice] = useState("");
    const [quantity, setQuantity] = useState("");

    const loadProducts = async () => {
        try {
            setLoading(true);
            setError("");

            const res = await axios.get(BASE_URL);
            setProducts(res.data);
        } catch (err) {
            console.log(err);
            setError("🚨 Backend is not reachable. Make sure Spring Boot is running.");
            setProducts([]);
        } finally {
            setLoading(false);
        }
    };

    useEffect(() => {
        loadProducts();
    }, []);

    const addProduct = async () => {
        try {
            await axios.post(BASE_URL, {
                name,
                price: Number(price),
                quantity: Number(quantity),
            });

            setName("");
            setPrice("");
            setQuantity("");
            setOpen(false);
            loadProducts();
        } catch (err) {
            console.log(err);
            setError("❌ Failed to add product");
        }
    };

    const deleteProduct = async (id: number) => {
        try {
            await axios.delete(`${BASE_URL}/${id}`);
            loadProducts();
        } catch (err) {
            console.log(err);
            setError("❌ Failed to delete product");
        }
    };

    const filtered = products.filter((p) =>
        p.name.toLowerCase().includes(search.toLowerCase())
    );

    return (
        <div style={styles.page}>
            {/* HEADER */}
            <div style={styles.header}>
                <h2>🌌 Galaxy Product Hub</h2>
                <b>Total: {products.length}</b>
            </div>

            {/* ERROR / LOADING */}
            {error && <div style={styles.error}>{error}</div>}
            {loading && <div style={styles.loading}>Loading galaxy data...</div>}

            {/* SEARCH */}
            <div style={{ padding: 15 }}>
                <input
                    placeholder="Search galaxy products..."
                    value={search}
                    onChange={(e) => setSearch(e.target.value)}
                    style={styles.search}
                />
            </div>

            {/* GRID */}
            <div style={styles.grid}>
                {filtered.map((p) => (
                    <div key={p.id} style={styles.card}>
                        <h3>{p.name}</h3>
                        <p>💰 ₱{p.price}</p>
                        <p>📦 {p.quantity}</p>

                        <button onClick={() => deleteProduct(p.id)} style={styles.deleteBtn}>
                            Delete
                        </button>
                    </div>
                ))}
            </div>

            {/* FLOAT BUTTON */}
            <button onClick={() => setOpen(true)} style={styles.fab}>
                +
            </button>

            {/* MODAL */}
            {open && (
                <div style={styles.modal}>
                    <div style={styles.modalBox}>
                        <h3>Add Product</h3>

                        <input placeholder="Name" value={name} onChange={(e) => setName(e.target.value)} style={styles.input} />
                        <input placeholder="Price" value={price} onChange={(e) => setPrice(e.target.value)} style={styles.input} />
                        <input placeholder="Quantity" value={quantity} onChange={(e) => setQuantity(e.target.value)} style={styles.input} />

                        <div>
                            <button onClick={addProduct} style={styles.saveBtn}>Save</button>
                            <button onClick={() => setOpen(false)} style={styles.cancelBtn}>Cancel</button>
                        </div>
                    </div>
                </div>
            )}
        </div>
    );
}

/* 🌌 STYLES */
const styles: any = {
    page: {
        minHeight: "100vh",
        background: "radial-gradient(circle at top, #1a0033, #000)",
        color: "white",
        fontFamily: "Arial",
    },

    header: {
        position: "sticky",
        top: 0,
        padding: 15,
        display: "flex",
        justifyContent: "space-between",
        background: "rgba(255,255,255,0.05)",
        backdropFilter: "blur(10px)",
        borderBottom: "1px solid rgba(168,85,247,0.3)",
    },

    error: {
        margin: 10,
        padding: 10,
        background: "rgba(255,0,0,0.2)",
        borderRadius: 10,
    },

    loading: {
        margin: 10,
        padding: 10,
        color: "#c084fc",
    },

    search: {
        width: "100%",
        padding: 12,
        borderRadius: 12,
        background: "rgba(255,255,255,0.08)",
        border: "1px solid #a855f7",
        color: "white",
    },

    grid: {
        display: "grid",
        gridTemplateColumns: "repeat(auto-fit, minmax(200px, 1fr))",
        gap: 15,
        padding: 20,
    },

    card: {
        padding: 15,
        borderRadius: 15,
        background: "linear-gradient(145deg, rgba(168,85,247,0.2), rgba(59,130,246,0.1))",
        border: "1px solid rgba(168,85,247,0.3)",
    },

    deleteBtn: {
        marginTop: 10,
        background: "red",
        border: "none",
        padding: "6px 10px",
        color: "white",
        borderRadius: 8,
        cursor: "pointer",
    },

    fab: {
        position: "fixed",
        bottom: 25,
        right: 25,
        width: 60,
        height: 60,
        borderRadius: "50%",
        fontSize: 28,
        background: "linear-gradient(135deg, #a855f7, #3b82f6)",
        border: "none",
        color: "white",
        cursor: "pointer",
    },

    modal: {
        position: "fixed",
        top: 0,
        left: 0,
        width: "100%",
        height: "100%",
        background: "rgba(0,0,0,0.7)",
        display: "flex",
        justifyContent: "center",
        alignItems: "center",
    },

    modalBox: {
        width: 350,
        padding: 20,
        borderRadius: 15,
        background: "rgba(20,0,40,0.9)",
        border: "1px solid #a855f7",
    },

    input: {
        width: "100%",
        marginBottom: 10,
        padding: 10,
        borderRadius: 10,
        background: "rgba(255,255,255,0.05)",
        border: "1px solid #a855f7",
        color: "white",
    },

    saveBtn: {
        background: "#a855f7",
        border: "none",
        padding: "8px 12px",
        marginRight: 10,
        borderRadius: 10,
        color: "white",
    },

    cancelBtn: {
        background: "transparent",
        border: "1px solid white",
        padding: "8px 12px",
        borderRadius: 10,
        color: "white",
    },
};
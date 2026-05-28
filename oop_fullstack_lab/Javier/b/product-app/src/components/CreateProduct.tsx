import { useState } from "react";
import apiClient from "./apiClient";
import { Product } from "./product";

// ─── Types ────────────────────────────────────────────────────────────────────

type Status = "idle" | "loading" | "success" | "error";

const CATEGORIES = [
    "Electronics",
    "Clothing",
    "Food & Beverage",
    "Books",
    "Furniture",
    "Toys",
    "Sports",
    "Other",
];

// ─── Hook ─────────────────────────────────────────────────────────────────────

const useCreateProduct = () => {
    const [status, setStatus] = useState<Status>("idle");
    const [result, setResult] = useState<Product | null>(null);
    const [error, setError] = useState<string | null>(null);

    const createProduct = async (name: string, category: string): Promise<void> => {
        setStatus("loading");
        setError(null);
        setResult(null);
        try {
            const response = await apiClient.post<Product>("/api/products/create", null, {
                params: { name, category },
            });
            setResult(response.data);
            setStatus("success");
        } catch (err: any) {
            setError(err.response?.data?.message || err.message || "Something went wrong.");
            setStatus("error");
        }
    };

    const reset = () => {
        setStatus("idle");
        setResult(null);
        setError(null);
    };

    return { createProduct, status, result, error, reset };
};

// ─── Component ────────────────────────────────────────────────────────────────

const CreateProduct = () => {
    const [name, setName] = useState("");
    const [category, setCategory] = useState("");
    const { createProduct, status, result, error, reset } = useCreateProduct();

    const loading = status === "loading";
    const canSubmit = name.trim().length > 0 && category.length > 0 && !loading;

    const handleSubmit = async () => {
        if (!canSubmit) return;
        await createProduct(name.trim(), category);
    };

    const handleReset = () => {
        setName("");
        setCategory("");
        reset();
    };

    return (
        <div style={{
            fontFamily: "'Sora', 'Helvetica Neue', sans-serif",
            minHeight: "100vh",
            background: "#0e0e11",
            display: "flex",
            alignItems: "center",
            justifyContent: "center",
            padding: "2rem",
        }}>
            <div style={{
                width: "100%",
                maxWidth: 440,
            }}>
                {/* Title */}
                <div style={{ marginBottom: "2rem" }}>
                    <p style={{ margin: "0 0 6px", fontSize: 11, letterSpacing: "0.15em", color: "#666", textTransform: "uppercase" }}>
                        Product Management
                    </p>
                    <h1 style={{
                        margin: 0,
                        fontSize: 32,
                        fontWeight: 700,
                        color: "#f5f5f5",
                        letterSpacing: "-1px",
                        lineHeight: 1.1,
                    }}>
                        New Product
                    </h1>
                </div>

                {/* Card */}
                <div style={{
                    background: "#16161a",
                    border: "1px solid #2a2a2e",
                    borderRadius: 16,
                    padding: "1.75rem",
                    display: "flex",
                    flexDirection: "column",
                    gap: "1.25rem",
                }}>

                    {/* Name field */}
                    <div style={{ display: "flex", flexDirection: "column", gap: 7 }}>
                        <label style={{ fontSize: 12, fontWeight: 600, color: "#888", letterSpacing: "0.08em", textTransform: "uppercase" }}>
                            Product Name
                        </label>
                        <input
                            type="text"
                            value={name}
                            onChange={e => { setName(e.target.value); if (status !== "idle") reset(); }}
                            placeholder="e.g. Wireless Headphones"
                            disabled={loading}
                            style={{
                                padding: "11px 14px",
                                background: "#0e0e11",
                                border: `1px solid ${name ? "#3a3a4a" : "#222226"}`,
                                borderRadius: 10,
                                fontSize: 14,
                                color: "#f0f0f0",
                                outline: "none",
                                transition: "border-color 0.15s",
                                opacity: loading ? 0.5 : 1,
                            }}
                            onFocus={e => (e.target.style.borderColor = "#6c63ff")}
                            onBlur={e => (e.target.style.borderColor = name ? "#3a3a4a" : "#222226")}
                        />
                    </div>

                    {/* Category field */}
                    <div style={{ display: "flex", flexDirection: "column", gap: 7 }}>
                        <label style={{ fontSize: 12, fontWeight: 600, color: "#888", letterSpacing: "0.08em", textTransform: "uppercase" }}>
                            Category
                        </label>
                        <select
                            value={category}
                            onChange={e => { setCategory(e.target.value); if (status !== "idle") reset(); }}
                            disabled={loading}
                            style={{
                                padding: "11px 14px",
                                background: "#0e0e11",
                                border: `1px solid ${category ? "#3a3a4a" : "#222226"}`,
                                borderRadius: 10,
                                fontSize: 14,
                                color: category ? "#f0f0f0" : "#555",
                                outline: "none",
                                cursor: "pointer",
                                transition: "border-color 0.15s",
                                opacity: loading ? 0.5 : 1,
                                appearance: "none",
                                backgroundImage: `url("data:image/svg+xml,%3Csvg xmlns='http://www.w3.org/2000/svg' width='12' height='12' viewBox='0 0 24 24' fill='none' stroke='%23666' stroke-width='2'%3E%3Cpath d='M6 9l6 6 6-6'/%3E%3C/svg%3E")`,
                                backgroundRepeat: "no-repeat",
                                backgroundPosition: "right 14px center",
                                paddingRight: 36,
                            }}
                            onFocus={e => (e.target.style.borderColor = "#6c63ff")}
                            onBlur={e => (e.target.style.borderColor = category ? "#3a3a4a" : "#222226")}
                        >
                            <option value="" disabled>Select a category…</option>
                            {CATEGORIES.map(c => (
                                <option key={c} value={c}>{c}</option>
                            ))}
                        </select>
                    </div>

                    {/* Divider */}
                    <div style={{ height: 1, background: "#1e1e22" }} />

                    {/* Submit button */}
                    <button
                        onClick={handleSubmit}
                        disabled={!canSubmit}
                        style={{
                            padding: "12px",
                            background: canSubmit ? "#6c63ff" : "#1e1e26",
                            border: "none",
                            borderRadius: 10,
                            fontSize: 14,
                            fontWeight: 600,
                            color: canSubmit ? "#fff" : "#444",
                            cursor: canSubmit ? "pointer" : "not-allowed",
                            transition: "background 0.2s, transform 0.1s",
                            display: "flex",
                            alignItems: "center",
                            justifyContent: "center",
                            gap: 8,
                            letterSpacing: "0.02em",
                        }}
                        onMouseEnter={e => { if (canSubmit) (e.currentTarget.style.background = "#7c74ff"); }}
                        onMouseLeave={e => { if (canSubmit) (e.currentTarget.style.background = "#6c63ff"); }}
                        onMouseDown={e => { if (canSubmit) (e.currentTarget.style.transform = "scale(0.98)"); }}
                        onMouseUp={e => { (e.currentTarget.style.transform = "scale(1)"); }}
                    >
                        {loading ? (
                            <>
                                <svg width="14" height="14" viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="2"
                                     style={{ animation: "spin 0.7s linear infinite" }}>
                                    <path d="M21 12a9 9 0 1 1-6.219-8.56" />
                                </svg>
                                Creating…
                            </>
                        ) : "Create Product →"}
                    </button>
                </div>

                {/* Success state */}
                {status === "success" && result && (
                    <div style={{
                        marginTop: "1rem",
                        background: "#0d1f14",
                        border: "1px solid #1a3d28",
                        borderRadius: 12,
                        padding: "1.1rem 1.25rem",
                        display: "flex",
                        flexDirection: "column",
                        gap: 10,
                        animation: "fadeUp 0.25s ease",
                    }}>
                        <div style={{ display: "flex", alignItems: "center", justifyContent: "space-between" }}>
                            <div style={{ display: "flex", alignItems: "center", gap: 7 }}>
                                <span style={{ fontSize: 16 }}>✓</span>
                                <span style={{ fontSize: 13, fontWeight: 600, color: "#4ade80" }}>Product created</span>
                            </div>
                            <button onClick={handleReset} style={{
                                fontSize: 11, color: "#4ade80", background: "transparent",
                                border: "1px solid #1a3d28", borderRadius: 6, padding: "3px 8px", cursor: "pointer",
                            }}>
                                + New
                            </button>
                        </div>
                        <div style={{ display: "flex", flexDirection: "column", gap: 5 }}>
                            {[
                                ["ID", result.id],
                                ["Name", result.name],
                                ["Category", result.category],
                            ].map(([label, val]) => (
                                <div key={label as string} style={{ display: "flex", justifyContent: "space-between", fontSize: 12 }}>
                                    <span style={{ color: "#555" }}>{label}</span>
                                    <span style={{ color: "#ccc", fontWeight: 500 }}>{String(val)}</span>
                                </div>
                            ))}
                        </div>
                    </div>
                )}

                {/* Error state */}
                {status === "error" && error && (
                    <div style={{
                        marginTop: "1rem",
                        background: "#1f0d0d",
                        border: "1px solid #3d1a1a",
                        borderRadius: 12,
                        padding: "1rem 1.25rem",
                        display: "flex",
                        alignItems: "flex-start",
                        gap: 10,
                        animation: "fadeUp 0.25s ease",
                    }}>
                        <span style={{ fontSize: 16, marginTop: 1 }}>⚠</span>
                        <div>
                            <p style={{ margin: "0 0 2px", fontSize: 13, fontWeight: 600, color: "#f87171" }}>Request failed</p>
                            <p style={{ margin: 0, fontSize: 12, color: "#a05555" }}>{error}</p>
                        </div>
                    </div>
                )}
            </div>

            <style>{`
                @import url('https://fonts.googleapis.com/css2?family=Sora:wght@400;600;700&display=swap');
                @keyframes spin { to { transform: rotate(360deg); } }
                @keyframes fadeUp { from { opacity: 0; transform: translateY(6px); } to { opacity: 1; transform: translateY(0); } }
                * { box-sizing: border-box; }
                input::placeholder { color: #444; }
                option { background: #16161a; color: #f0f0f0; }
            `}</style>
        </div>
    );
};

export default CreateProduct;
import reactLogo from './assets/react.svg'
import viteLogo from './assets/vite.svg'
import heroImg from './assets/hero.png'
import ProductList from './components/ProductList'
import ProductCreate from './components/ProductCreate'
import { useProducts } from './hooks/useProducts'
import './App.css'

function App() {
  const { products, loading, error, refresh, editProduct, removeProduct } = useProducts()

  const handleCounterClick = () => {
    if (products.length === 0) return
    const lastProduct = products[products.length - 1]
    const element = document.getElementById(`product-${lastProduct.id}`)
    if (element) {
      element.scrollIntoView({ behavior: 'smooth', block: 'center' })
    }
  }

  return (
    <>
      <section id="center">
        <div className="hero">
          <img src={heroImg} className="base" width="170" height="179" alt="" />
          <img src={reactLogo} className="framework" alt="React logo" />
          <img src={viteLogo} className="vite" alt="Vite logo" />
        </div>
        <div>
          <h1>Welcome to Product Counter</h1>
          <h4>Made by Cantela</h4>

          {/* <p>
            Edit <code>src/App.tsx</code> and save to test <code>HMR</code>
          </p> */}

        </div>
        <button
          type="button"
          className="counter"
          onClick={handleCounterClick}
        >
          Products: {products.length}
        </button>
      </section>

      <ProductCreate onCreated={refresh} />
      <ProductList products={products} loading={loading} error={error} refresh={refresh} editProduct={editProduct} removeProduct={removeProduct} />

      <div className="ticks"></div>

      <section id="next-steps">
        <div id="docs">
          <svg className="icon" role="presentation" aria-hidden="true">
            <use href="/icons.svg#documentation-icon"></use>
          </svg>
          <h2>Documentation</h2>
          <p>Evidence Video</p>
          <div className="doc-video">
            <video controls width="400">
              <source src="/evidence_Vz6ZZgFl.mp4" type="video/mp4" />
              Your browser does not support the video tag.
            </video>
          </div>
          <ul>
            <li>
              <a href="https://vite.dev/" target="_blank">
                <img className="logo" src={viteLogo} alt="" />
                Explore Vite
              </a>
            </li>
            <li>
              <a href="https://react.dev/" target="_blank">
                <img className="button-icon" src={reactLogo} alt="" />
                Learn more
              </a>
            </li>
          </ul>
        </div>
        <div id="social">
          <svg className="icon" role="presentation" aria-hidden="true">
            <use href="/icons.svg#social-icon"></use>
          </svg>
          <h2>Connect with JAVAII</h2>
          <p>Join the JAVAII community</p>
          <ul>
            <li>
              <a href="https://github.com/javai222/javai" target="_blank">
                <svg
                  className="button-icon"
                  role="presentation"
                  aria-hidden="true"
                >
                  <use href="/icons.svg#github-icon"></use>
                </svg>
                GitHub
              </a>
            </li>
            <li>
              <a href="https://discord.com/channels/1480744471183233044/1480744471716036805" target="_blank">
                <svg
                  className="button-icon"
                  role="presentation"
                  aria-hidden="true"
                >
                  <use href="/icons.svg#discord-icon"></use>
                </svg>
                Discord
              </a>
            </li>
            <li>
              <a href="https://www.linkedin.com/in/chris-nelson-cantela-912288374/" target="_blank">
                <svg
                  className="button-icon"
                  role="presentation"
                  aria-hidden="true"
                >
                  <use href="/icons.svg#linkedin-icon"></use>
                </svg>
                LinkedIn
              </a>
            </li>
            <li>
              <a href="https://www.facebook.com/chrisnelson.cantela.7" target="_blank">
                <svg
                  className="button-icon"
                  role="presentation"
                  aria-hidden="true"
                >
                  <use href="/icons.svg#facebook-icon"></use>
                </svg>
                Facebook
              </a>
            </li>
          </ul>
        </div>
      </section>

      <div className="ticks"></div>
    </>
  )
}

export default App

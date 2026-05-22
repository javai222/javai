import UserList from './components/UserList'
import './App.css'

function App() {

  return (
    <>
      <main className="app-main">
        <section className="hero-section">
          <div className="hero-content">
            <h1 className="hero-title">Welcome</h1>
            <p className="hero-subtitle">Manage and explore our community members</p>
            <p className="hero-description">
              A modern, professional platform to connect and collaborate with talented individuals across diverse programs.
            </p>
          </div>
        </section>

        <section className="features-section">
          <div className="feature-grid">
            <article className="feature-card">
              <div className="feature-icon">👥</div>
              <h3>Community</h3>
              <p>Connect with members from various programs and backgrounds</p>
            </article>
            <article className="feature-card">
              <div className="feature-icon">🚀</div>
              <h3>Growth</h3>
              <p>Discover opportunities to learn and collaborate with peers</p>
            </article>
            <article className="feature-card">
              <div className="feature-icon">💡</div>
              <h3>Innovation</h3>
              <p>Share ideas and build something amazing together</p>
            </article>
          </div>
        </section>

        <section className="users-section">
          <UserList />
        </section>

        <footer className="app-footer">
          <div>
            <p>&copy; 2026. Building connections, one profile at a time.</p>
          </div>
        </footer>
      </main>
    </>
  )
}

export default App

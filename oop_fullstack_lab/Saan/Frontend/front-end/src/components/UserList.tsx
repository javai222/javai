import { useState } from 'react';
import { useUserList } from '../hooks/Userhooks';
import { UserEditModal } from './UserEditModal';
import type User from '../types/usertypes';

const listStyles: Record<string, string> = {
  wrapper: 'user-list-wrapper',
  heading: 'user-list-heading',
  state: 'user-list-state',
  grid: 'user-list-grid',
  card: 'user-card',
  cardActions: 'user-card-actions',
  idBadge: 'user-id-badge',
  name: 'user-name',
  program: 'user-program',
  refreshButton: 'user-refresh-button',
  deleteButton: 'user-delete-button',
  editButton: 'user-edit-button',
  formSection: 'user-form-section',
  formGroup: 'form-group',
  formInput: 'form-input',
  formButton: 'form-button',
  errorMessage: 'error-message',
};

const css = `
@keyframes cardFadeIn {
  from {
    opacity: 0;
    transform: translateY(20px);
  }
  to {
    opacity: 1;
    transform: translateY(0);
  }
}

@keyframes shimmer {
  0% {
    box-shadow: 0 0 0 rgba(170, 59, 255, 0.1);
  }
  50% {
    box-shadow: 0 8px 24px rgba(170, 59, 255, 0.15);
  }
  100% {
    box-shadow: 0 0 0 rgba(170, 59, 255, 0.1);
  }
}

.${listStyles.wrapper} {
  width: 100%;
}

.${listStyles.heading} {
  color: var(--text-h);
  font-size: 28px;
  margin: 0 0 48px;
  font-weight: 600;
  text-align: center;
}

.${listStyles.state} {
  color: var(--text);
  text-align: center;
  padding: 40px 20px;
  font-size: 16px;
}

.${listStyles.formSection} {
  background: var(--accent-bg);
  border: 1px solid var(--border);
  border-radius: 12px;
  padding: 24px;
  margin-bottom: 32px;
  max-width: 600px;
  margin-left: auto;
  margin-right: auto;
}

.${listStyles.formGroup} {
  margin-bottom: 16px;
}

.${listStyles.formGroup}:last-child {
  margin-bottom: 0;
}

.${listStyles.formGroup} label {
  display: block;
  color: var(--text-h);
  font-size: 14px;
  font-weight: 600;
  margin-bottom: 8px;
  text-transform: uppercase;
  letter-spacing: 0.5px;
}

.${listStyles.formInput} {
  width: 100%;
  padding: 10px 12px;
  border: 1px solid var(--border);
  border-radius: 6px;
  background: var(--bg);
  color: var(--text);
  font-size: 14px;
  transition: border-color 0.3s ease;
  box-sizing: border-box;
}

.${listStyles.formInput}:focus {
  outline: none;
  border-color: var(--accent);
  box-shadow: 0 0 0 2px rgba(170, 59, 255, 0.1);
}

.${listStyles.formButton} {
  width: 100%;
  padding: 12px 24px;
  border: none;
  border-radius: 8px;
  background: var(--accent);
  color: white;
  font-size: 14px;
  font-weight: 600;
  cursor: pointer;
  transition: all 0.3s ease;
  text-transform: uppercase;
  letter-spacing: 0.5px;
}

.${listStyles.formButton}:hover {
  box-shadow: 0 8px 20px rgba(170, 59, 255, 0.3);
  transform: translateY(-2px);
}

.${listStyles.formButton}:active {
  transform: translateY(0);
}

.${listStyles.formButton}:disabled {
  opacity: 0.6;
  cursor: not-allowed;
}

.${listStyles.grid} {
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(280px, 1fr));
  gap: 24px;
  width: 100%;
}

.${listStyles.card} {
  border: 1px solid var(--border);
  border-radius: 12px;
  padding: 24px;
  background: var(--bg);
  transition: all 0.3s cubic-bezier(0.34, 1.56, 0.64, 1);
  animation: cardFadeIn 0.6s ease-out forwards;
  cursor: default;
  position: relative;
  overflow: hidden;
  display: flex;
  flex-direction: column;
}

.${listStyles.card}:nth-child(1) { animation-delay: 0.1s; }
.${listStyles.card}:nth-child(2) { animation-delay: 0.2s; }
.${listStyles.card}:nth-child(3) { animation-delay: 0.3s; }
.${listStyles.card}:nth-child(4) { animation-delay: 0.4s; }
.${listStyles.card}:nth-child(5) { animation-delay: 0.5s; }
.${listStyles.card}:nth-child(6) { animation-delay: 0.6s; }

.${listStyles.card}::before {
  content: '';
  position: absolute;
  top: 0;
  left: -100%;
  width: 100%;
  height: 100%;
  background: linear-gradient(90deg, transparent, rgba(170, 59, 255, 0.1), transparent);
  transition: left 0.5s ease;
}

.${listStyles.card}:hover::before {
  left: 100%;
}

.${listStyles.card}:hover {
  border-color: var(--accent);
  box-shadow: 0 12px 32px rgba(170, 59, 255, 0.15);
  transform: translateY(-6px);
}

.${listStyles.idBadge} {
  display: inline-block;
  margin-bottom: 12px;
  font-size: 12px;
  font-weight: 700;
  color: var(--accent);
  background: var(--accent-bg);
  padding: 6px 12px;
  border-radius: 6px;
  letter-spacing: 0.5px;
  text-transform: uppercase;
}

.${listStyles.name} {
  margin: 12px 0 8px;
  color: var(--text-h);
  font-size: 18px;
  font-weight: 600;
}

.${listStyles.program} {
  margin: 0 0 16px;
  color: var(--text);
  font-size: 13px;
  font-weight: 500;
  letter-spacing: 0.5px;
  text-transform: uppercase;
  opacity: 0.8;
  flex-grow: 1;
}

.${listStyles.cardActions} {
  display: flex;
  gap: 8px;
}

.${listStyles.deleteButton} {
  flex: 1;
  border: 1px solid #ff6b6b;
  border-radius: 6px;
  background: rgba(255, 107, 107, 0.1);
  color: #ff6b6b;
  padding: 8px 12px;
  cursor: pointer;
  font-size: 12px;
  font-weight: 600;
  transition: all 0.3s ease;
  text-transform: uppercase;
  letter-spacing: 0.5px;
}

.${listStyles.deleteButton}:hover {
  background: #ff6b6b;
  color: white;
  box-shadow: 0 4px 12px rgba(255, 107, 107, 0.3);
}

.${listStyles.deleteButton}:active {
  transform: scale(0.98);
}

.${listStyles.editButton} {
  flex: 1;
  border: 1px solid var(--accent);
  border-radius: 6px;
  background: rgba(170, 59, 255, 0.1);
  color: var(--accent);
  padding: 8px 12px;
  cursor: pointer;
  font-size: 12px;
  font-weight: 600;
  transition: all 0.3s ease;
  text-transform: uppercase;
  letter-spacing: 0.5px;
}

.${listStyles.editButton}:hover {
  background: var(--accent);
  color: white;
  box-shadow: 0 4px 12px rgba(170, 59, 255, 0.3);
}

.${listStyles.editButton}:active {
  transform: scale(0.98);
}

.${listStyles.refreshButton} {
  display: inline-block;
  margin-top: 32px;
  border: 1px solid var(--accent);
  border-radius: 8px;
  background: var(--accent-bg);
  color: var(--accent);
  padding: 10px 24px;
  cursor: pointer;
  font-size: 14px;
  font-weight: 600;
  transition: all 0.3s ease;
}

.${listStyles.refreshButton}:hover {
  background: var(--accent);
  color: white;
  box-shadow: 0 8px 20px rgba(170, 59, 255, 0.3);
}

.${listStyles.refreshButton}:active {
  transform: scale(0.98);
}

.${listStyles.errorMessage} {
  color: #ff6b6b;
  background: rgba(255, 107, 107, 0.1);
  border: 1px solid #ff6b6b;
  border-radius: 6px;
  padding: 12px 16px;
  margin-bottom: 16px;
  font-size: 14px;
  text-align: center;
}
`;

function UserList() {
  const { users, loading, error, isAdding, isUpdating, fetchUsers, addUser, removeUser, updateUser } =
    useUserList();
  const [formData, setFormData] = useState<{ name: string; program: string }>({
    name: '',
    program: '',
  });
  const [formError, setFormError] = useState<string | null>(null);
  const [editingUser, setEditingUser] = useState<User | null>(null);
  const [isEditModalOpen, setIsEditModalOpen] = useState(false);

  const handleInputChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    const { name, value } = e.target;
    setFormData(prev => ({
      ...prev,
      [name]: value,
    }));
    setFormError(null);
  };

  const handleAddUser = async (e: React.FormEvent) => {
    e.preventDefault();
    setFormError(null);

    if (!formData.name.trim() || !formData.program.trim()) {
      setFormError('Please fill in all fields');
      return;
    }

    try {
      await addUser({
        id: '', // Backend will generate this
        name: formData.name.trim(),
        program: formData.program.trim(),
      });
      setFormData({ name: '', program: '' });
    } catch {
      setFormError('Failed to add user. Please try again.');
    }
  };

  const handleDeleteUser = async (id: string) => {
    if (confirm('Are you sure you want to delete this user?')) {
      try {
        await removeUser(id);
      } catch {
        setFormError('Failed to delete user. Please try again.');
      }
    }
  };

  const handleEditClick = (user: User) => {
    setEditingUser(user);
    setIsEditModalOpen(true);
  };

  const handleEditSave = async (updates: Partial<Omit<User, 'id'>>) => {
    if (!editingUser) return;
    try {
      await updateUser(editingUser.id, updates);
      setEditingUser(null);
    } catch {
      throw new Error('Failed to update user');
    }
  };

  if (loading) {
    return <p className={listStyles.state}>Loading users...</p>;
  }

  if (error && users.length === 0) {
    return (
      <div className={listStyles.wrapper}>
        <p className={listStyles.state}>Error: {error}</p>
        <div style={{ textAlign: 'center' }}>
          <button className={listStyles.refreshButton} onClick={fetchUsers} type="button">
            Retry
          </button>
        </div>
      </div>
    );
  }

  return (
    <section className={listStyles.wrapper} aria-label="Users">
      <style>{css}</style>
      <h2 className={listStyles.heading}>Community Members</h2>

      {/* Add User Form */}
      <form className={listStyles.formSection} onSubmit={handleAddUser}>
        <h3 style={{ color: 'var(--text-h)', marginTop: 0, marginBottom: '20px' }}>Add New Member</h3>
        {formError && <div className={listStyles.errorMessage}>{formError}</div>}
        
        <div className={listStyles.formGroup}>
          <label htmlFor="name">Name</label>
          <input
            id="name"
            type="text"
            name="name"
            className={listStyles.formInput}
            value={formData.name}
            onChange={handleInputChange}
            placeholder="Enter full name"
            disabled={isAdding}
          />
        </div>

        <div className={listStyles.formGroup}>
          <label htmlFor="program">Program</label>
          <input
            id="program"
            type="text"
            name="program"
            className={listStyles.formInput}
            value={formData.program}
            onChange={handleInputChange}
            placeholder="Enter program"
            disabled={isAdding}
          />
        </div>

        <button
          type="submit"
          className={listStyles.formButton}
          disabled={isAdding}
        >
          {isAdding ? 'Adding...' : 'Add Member'}
        </button>
      </form>

      {/* Users Grid */}
      {users.length === 0 ? (
        <p className={listStyles.state}>No users found.</p>
      ) : (
        <div className={listStyles.grid}>
          {users.map((user) => (
            <article key={user.id} className={listStyles.card}>
              <span className={listStyles.idBadge}>ID: {user.id}</span>
              <h3 className={listStyles.name}>{user.name}</h3>
              <p className={listStyles.program}>{user.program}</p>
              <div className={listStyles.cardActions}>
                <button
                  className={listStyles.editButton}
                  onClick={() => handleEditClick(user)}
                  type="button"
                  aria-label={`Edit ${user.name}`}
                  disabled={isUpdating === user.id}
                >
                  {isUpdating === user.id ? 'Updating...' : 'Edit'}
                </button>
                <button
                  className={listStyles.deleteButton}
                  onClick={() => handleDeleteUser(user.id)}
                  type="button"
                  aria-label={`Delete ${user.name}`}
                >
                  Delete
                </button>
              </div>
            </article>
          ))}
        </div>
      )}

      {users.length > 0 && (
        <div style={{ textAlign: 'center' }}>
          <button className={listStyles.refreshButton} onClick={fetchUsers} type="button">
            Refresh
          </button>
        </div>
      )}

      {editingUser && (
        <UserEditModal
          user={editingUser}
          isOpen={isEditModalOpen}
          isLoading={isUpdating === editingUser.id}
          onClose={() => {
            setIsEditModalOpen(false);
            setEditingUser(null);
          }}
          onSave={handleEditSave}
        />
      )}
    </section>
  );
}

export default UserList;

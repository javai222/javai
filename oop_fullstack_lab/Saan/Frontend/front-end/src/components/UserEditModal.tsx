import React, { useState, useEffect } from 'react';
import type User from '../types/usertypes';

interface UserEditModalProps {
  user: User;
  isOpen: boolean;
  isLoading: boolean;
  onClose: () => void;
  onSave: (updates: Partial<Omit<User, 'id'>>) => Promise<void>;
}

const modalStyles: Record<string, string> = {
  overlay: 'modal-overlay',
  modal: 'modal-content',
  header: 'modal-header',
  title: 'modal-title',
  body: 'modal-body',
  footer: 'modal-footer',
  formGroup: 'modal-form-group',
  label: 'modal-label',
  input: 'modal-input',
  idField: 'modal-id-field',
  idReadonly: 'modal-id-readonly',
  submitButton: 'modal-submit-button',
  cancelButton: 'modal-cancel-button',
  errorMessage: 'modal-error-message',
};

const css = `
.${modalStyles.overlay} {
  position: fixed;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  background: rgba(0, 0, 0, 0.5);
  display: flex;
  align-items: center;
  justify-content: center;
  z-index: 1000;
  animation: fadeIn 0.3s ease;
}

@keyframes fadeIn {
  from {
    opacity: 0;
  }
  to {
    opacity: 1;
  }
}

@keyframes slideIn {
  from {
    transform: translateY(-20px);
    opacity: 0;
  }
  to {
    transform: translateY(0);
    opacity: 1;
  }
}

.${modalStyles.modal} {
  background: var(--bg);
  border-radius: 12px;
  border: 1px solid var(--border);
  box-shadow: 0 20px 60px rgba(0, 0, 0, 0.3);
  max-width: 500px;
  width: 90%;
  animation: slideIn 0.3s ease;
  display: flex;
  flex-direction: column;
}

.${modalStyles.header} {
  border-bottom: 1px solid var(--border);
  padding: 20px 24px;
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.${modalStyles.title} {
  margin: 0;
  color: var(--text-h);
  font-size: 20px;
  font-weight: 600;
}

.${modalStyles.body} {
  padding: 24px;
  flex: 1;
  overflow-y: auto;
  max-height: calc(100vh - 200px);
}

.${modalStyles.formGroup} {
  margin-bottom: 20px;
}

.${modalStyles.formGroup}:last-of-type {
  margin-bottom: 0;
}

.${modalStyles.label} {
  display: block;
  color: var(--text-h);
  font-size: 14px;
  font-weight: 600;
  margin-bottom: 8px;
  text-transform: uppercase;
  letter-spacing: 0.5px;
}

.${modalStyles.input} {
  width: 100%;
  padding: 10px 12px;
  border: 1px solid var(--border);
  border-radius: 6px;
  background: var(--bg);
  color: var(--text);
  font-size: 14px;
  transition: border-color 0.3s ease;
  box-sizing: border-box;
  font-family: inherit;
}

.${modalStyles.input}:focus {
  outline: none;
  border-color: var(--accent);
  box-shadow: 0 0 0 2px rgba(170, 59, 255, 0.1);
}

.${modalStyles.idField} {
  position: relative;
}

.${modalStyles.idReadonly} {
  background: var(--accent-bg);
  cursor: not-allowed;
  opacity: 0.7;
}

.${modalStyles.idReadonly}:focus {
  border-color: var(--border);
  box-shadow: none;
}

.${modalStyles.idReadonly}::after {
  content: '(Read-only)';
  position: absolute;
  right: 12px;
  top: 50%;
  transform: translateY(-50%);
  font-size: 12px;
  color: var(--text);
  opacity: 0.6;
  pointer-events: none;
  font-weight: 600;
}

.${modalStyles.footer} {
  border-top: 1px solid var(--border);
  padding: 16px 24px;
  display: flex;
  gap: 12px;
  justify-content: flex-end;
}

.${modalStyles.submitButton} {
  padding: 10px 24px;
  border: none;
  border-radius: 6px;
  background: var(--accent);
  color: white;
  font-size: 14px;
  font-weight: 600;
  cursor: pointer;
  transition: all 0.3s ease;
  text-transform: uppercase;
  letter-spacing: 0.5px;
}

.${modalStyles.submitButton}:hover:not(:disabled) {
  box-shadow: 0 8px 20px rgba(170, 59, 255, 0.3);
  transform: translateY(-2px);
}

.${modalStyles.submitButton}:active:not(:disabled) {
  transform: translateY(0);
}

.${modalStyles.submitButton}:disabled {
  opacity: 0.6;
  cursor: not-allowed;
}

.${modalStyles.cancelButton} {
  padding: 10px 24px;
  border: 1px solid var(--border);
  border-radius: 6px;
  background: transparent;
  color: var(--text);
  font-size: 14px;
  font-weight: 600;
  cursor: pointer;
  transition: all 0.3s ease;
  text-transform: uppercase;
  letter-spacing: 0.5px;
}

.${modalStyles.cancelButton}:hover:not(:disabled) {
  background: var(--accent-bg);
  border-color: var(--accent);
  color: var(--accent);
}

.${modalStyles.cancelButton}:disabled {
  opacity: 0.6;
  cursor: not-allowed;
}

.${modalStyles.errorMessage} {
  background: rgba(255, 107, 107, 0.1);
  border: 1px solid #ff6b6b;
  color: #ff6b6b;
  border-radius: 6px;
  padding: 12px 16px;
  margin-bottom: 16px;
  font-size: 14px;
}
`;

export const UserEditModal: React.FC<UserEditModalProps> = ({
  user,
  isOpen,
  isLoading,
  onClose,
  onSave,
}) => {
  const [formData, setFormData] = useState({
    name: user.name,
    program: user.program,
  });
  const [error, setError] = useState<string | null>(null);
  const [hasChanges, setHasChanges] = useState(false);

  // Reset form when user changes or modal closes
  useEffect(() => {
    if (isOpen) {
      setFormData({
        name: user.name,
        program: user.program,
      });
      setError(null);
      setHasChanges(false);
    }
  }, [isOpen, user]);

  const handleInputChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    const { name, value } = e.target;
    setFormData(prev => ({
      ...prev,
      [name]: value,
    }));

    setHasChanges(true);
    setError(null);
  };

  const handleSave = async () => {
    setError(null);

    // Validation
    if (!formData.name.trim()) {
      setError('Name cannot be empty');
      return;
    }
    if (!formData.program.trim()) {
      setError('Program cannot be empty');
      return;
    }

    try {
      await onSave({
        name: formData.name.trim(),
        program: formData.program.trim(),
      });
      onClose();
    } catch (err) {
      setError(
        err instanceof Error ? err.message : 'Failed to update user'
      );
    }
  };

  const handleCancel = () => {
    setFormData({
      name: user.name,
      program: user.program,
    });
    setError(null);
    setHasChanges(false);
    onClose();
  };

  if (!isOpen) return null;

  return (
    <>
      <style>{css}</style>
      <div className={modalStyles.overlay} onClick={handleCancel}>
        <div
          className={modalStyles.modal}
          onClick={e => e.stopPropagation()}
          role="dialog"
          aria-modal="true"
          aria-labelledby="modal-title"
        >
          <div className={modalStyles.header}>
            <h2 id="modal-title" className={modalStyles.title}>
              Edit Member
            </h2>
          </div>

          <div className={modalStyles.body}>
            {error && <div className={modalStyles.errorMessage}>{error}</div>}

            <div className={modalStyles.formGroup}>
              <label className={modalStyles.label} htmlFor="edit-id">
                ID
              </label>
              <div className={modalStyles.idField}>
                <input
                  id="edit-id"
                  type="text"
                  value={user.id}
                  disabled={true}
                  className={`${modalStyles.input} ${modalStyles.idReadonly}`}
                  aria-readonly="true"
                />
              </div>
            </div>

            <div className={modalStyles.formGroup}>
              <label className={modalStyles.label} htmlFor="edit-name">
                Name
              </label>
              <input
                id="edit-name"
                type="text"
                name="name"
                value={formData.name}
                onChange={handleInputChange}
                className={modalStyles.input}
                placeholder="Enter full name"
                disabled={isLoading}
              />
            </div>

            <div className={modalStyles.formGroup}>
              <label className={modalStyles.label} htmlFor="edit-program">
                Program
              </label>
              <input
                id="edit-program"
                type="text"
                name="program"
                value={formData.program}
                onChange={handleInputChange}
                className={modalStyles.input}
                placeholder="Enter program"
                disabled={isLoading}
              />
            </div>
          </div>

          <div className={modalStyles.footer}>
            <button
              className={modalStyles.cancelButton}
              onClick={handleCancel}
              disabled={isLoading}
              type="button"
            >
              Cancel
            </button>
            <button
              className={modalStyles.submitButton}
              onClick={handleSave}
              disabled={isLoading || !hasChanges}
              type="button"
            >
              {isLoading ? 'Saving...' : 'Save Changes'}
            </button>
          </div>
        </div>
      </div>
    </>
  );
};

export default UserEditModal;

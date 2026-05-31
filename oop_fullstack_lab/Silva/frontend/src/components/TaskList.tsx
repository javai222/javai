import { type Task } from '../types';

interface TaskListProps {
    tasks: Task[];
    onToggleComplete: (task: Task) => void;
    onDelete: (id?: number) => void;
}

export default function TaskList({ tasks, onToggleComplete, onDelete }: TaskListProps) {
    return (
        <div style={{ display: 'flex', flexDirection: 'column', gap: '10px' }}>
            {tasks.map((task) => (
                <div
                    key={task.id}
                    style={{
                        display: 'flex',
                        justifyContent: 'space-between',
                        alignItems: 'center',
                        padding: '10px',
                        border: '1px solid #ccc',
                        borderRadius: '4px',
                        background: task.completed ? '#e9ecef' : '#fff'
                    }}
                >
                    <div style={{ flexGrow: 1, textDecoration: task.completed ? 'line-through' : 'none' }}>
                        <strong>{task.title}</strong>
                        {task.description && (
                            <p style={{ margin: '4px 0 0 0', fontSize: '14px', color: '#6c757d' }}>
                                {task.description}
                            </p>
                        )}
                    </div>
                    <div style={{ display: 'flex', gap: '5px' }}>
                        <button onClick={() => onToggleComplete(task)} style={{ padding: '5px' }}>
                            {task.completed ? 'Undo' : 'Complete'}
                        </button>
                        <button
                            onClick={() => onDelete(task.id)}
                            style={{ padding: '5px', background: '#dc3545', color: '#fff', border: 'none', cursor: 'pointer' }}
                        >
                            Delete
                        </button>
                    </div>
                </div>
            ))}
        </div>
    );
}
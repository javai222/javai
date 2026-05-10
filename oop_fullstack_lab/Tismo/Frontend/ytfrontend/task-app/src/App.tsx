import TaskForm from "./components/TaskForm";
import TaskList from "./components/TaskList";
import { useTasks } from "./hooks/useTask";
import type { Task } from "./types/Task";
import "./App.css";

function App() {
    const { tasks, createTask, updateTask, removeTask } = useTasks();

    const handleToggle = (task: Task) => {
        updateTask(task.id!, {
            ...task,
            completed: !task.completed,
        });
    };

    return (
        <div className="space-bg">
            <div className="stars"></div>
            <div className="stars2"></div>
            <div className="stars3"></div>

            <div className="app-container">
                <div className="glass-card">
                    <h1 className="title">🌌 Galaxy Task Manager</h1>

                    <p className="subtitle">
                        Organize your universe, one task at a time.
                    </p>

                    <TaskForm onAdd={createTask} />

                    <TaskList
                        tasks={tasks}
                        onToggle={handleToggle}
                        onDelete={removeTask}
                    />
                </div>
            </div>
        </div>
    );
}

export default App;
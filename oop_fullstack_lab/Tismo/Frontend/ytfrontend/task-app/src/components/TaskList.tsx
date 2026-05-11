import type { Task } from "../types/Task";

interface Props {
    tasks: Task[];
    onToggle: (task: Task) => void;
    onDelete: (id: number) => void;
}

const TaskList = ({ tasks, onToggle, onDelete }: Props) => {
    return (
        <ul>
            {tasks.map(task => (
                <li key={task.id}>
                    <span
                        className={task.completed ? "completed" : ""}
                        onClick={() => onToggle(task)}
                        style={{ cursor: "pointer" }}
                    >
                        {task.title}
                    </span>

                    <button onClick={() => onDelete(task.id!)}>
                        Delete
                    </button>
                </li>
            ))}
        </ul>
    );
};

export default TaskList;
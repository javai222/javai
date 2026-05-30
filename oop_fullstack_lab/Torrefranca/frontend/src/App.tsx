import { useEffect, useState } from "react";
import {
  getTasks,
  createTask,
  updateTask,
  deleteTask,
} from "./services/taskService";
import type { Task } from "./types/Task";

function App() {
  const [tasks, setTasks] = useState<Task[]>([]);

  const [title, setTitle] = useState("");
  const [description, setDescription] = useState("");

  const [editingId, setEditingId] = useState<number | null>(null);

  useEffect(() => {
    loadTasks();
  }, []);

  const loadTasks = async () => {
    const response = await getTasks();
    setTasks(response.data);
  };

  const handleSubmit = async () => {
    if (!title.trim()) return;

    if (editingId !== null) {
      const existingTask = tasks.find(
        (task) => task.id === editingId
      );

      await updateTask(editingId, {
        id: editingId,
        title,
        description,
        completed: existingTask?.completed ?? false,
      });

      setEditingId(null);
    } else {
      await createTask({
        title,
        description,
        completed: false,
      });
    }

    setTitle("");
    setDescription("");

    loadTasks();
  };

  const handleEdit = (task: Task) => {
    setEditingId(task.id!);
    setTitle(task.title);
    setDescription(task.description);
  };

  const handleDelete = async (id: number) => {
    await deleteTask(id);
    loadTasks();
  };

  const handleToggleComplete = async (
    task: Task
  ) => {
    await updateTask(task.id!, {
      ...task,
      completed: !task.completed,
    });

    loadTasks();
  };

  return (
    <div
      style={{
        maxWidth: "800px",
        margin: "auto",
        padding: "20px",
      }}
    >
      <h1>Task Manager</h1>

      <div
        style={{
          display: "flex",
          flexDirection: "column",
          gap: "10px",
          marginBottom: "20px",
        }}
      >
        <input
          type="text"
          placeholder="Task Title"
          value={title}
          onChange={(e) =>
            setTitle(e.target.value)
          }
        />

        <textarea
          placeholder="Task Description"
          value={description}
          onChange={(e) =>
            setDescription(e.target.value)
          }
        />

        <button onClick={handleSubmit}>
          {editingId !== null
            ? "Update Task"
            : "Add Task"}
        </button>
      </div>

      {tasks.length === 0 ? (
        <p>No tasks found.</p>
      ) : (
        tasks.map((task) => (
          <div
            key={task.id}
            style={{
              border: "1px solid #ccc",
              padding: "15px",
              marginBottom: "10px",
              borderRadius: "8px",
            }}
          >
            <h3>{task.title}</h3>

            <p>{task.description}</p>

            <p>
              Status:
              {" "}
              {task.completed
                ? "Completed"
                : "Not Completed"}
            </p>

            <div
              style={{
                display: "flex",
                gap: "10px",
              }}
            >
              <button
                onClick={() =>
                  handleEdit(task)
                }
              >
                Edit
              </button>

              <button
                onClick={() =>
                  handleToggleComplete(task)
                }
              >
                Toggle Status
              </button>

              <button
                onClick={() =>
                  handleDelete(task.id!)
                }
              >
                Delete
              </button>
            </div>
          </div>
        ))
      )}
    </div>
  );
}

export default App;
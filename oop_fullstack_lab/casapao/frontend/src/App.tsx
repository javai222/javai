import { useEffect, useState } from "react";

type Task = {
  id: number;
  title: string;
  description: string;
  completed: boolean;
};

function App() {
  const [tasks, setTasks] = useState<Task[]>([]);
  const [title, setTitle] = useState("");
  const [description, setDescription] = useState("");

  // Central fetch function
  const fetchTasks = () => {
    fetch("http://localhost:8080/api/tasks")
        .then(res => res.json())
        .then(data => setTasks(data))
        .catch(err => console.error("Fetch error:", err));
  };

  useEffect(() => {
    fetchTasks();
  }, []);

  // ADD TASK (with validation)
  const addTask = () => {
    if (!title.trim() || !description.trim()) return;

    fetch("http://localhost:8080/api/tasks", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({
        title,
        description,
        completed: false
      })
    })
        .then(() => {
          setTitle("");
          setDescription("");
          fetchTasks();
        })
        .catch(err => console.error("Add error:", err));
  };

  //  DELETE TASK
  const deleteTask = (id: number) => {
    fetch(`http://localhost:8080/api/tasks/${id}`, {
      method: "DELETE"
    })
        .then(() => fetchTasks())
        .catch(err => console.error("Delete error:", err));
  };

  // TOGGLE TASK
  const toggleTask = (task: Task) => {
    fetch(`http://localhost:8080/api/tasks/${task.id}`, {
      method: "PUT",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({
        ...task,
        completed: !task.completed
      })
    })
        .then(() => fetchTasks())
        .catch(err => console.error("Update error:", err));
  };

  return (
      <div style={{ padding: 20, maxWidth: 500, margin: "auto" }}>
        <h1>Task Manager</h1>

        {/* FORM */}
        <input
            placeholder="Title"
            value={title}
            onChange={(e) => setTitle(e.target.value)}
        />

        <input
            placeholder="Description"
            value={description}
            onChange={(e) => setDescription(e.target.value)}
        />

        <button
            onClick={addTask}
            disabled={!title.trim() || !description.trim()}
        >
          Add Task
        </button>

        <hr />

        {/* TASK LIST */}
        {tasks.length === 0 && <p>No tasks available</p>}

        {tasks.map(task => (
            <div
                key={task.id}
                style={{
                  marginBottom: 10,
                  padding: 10,
                  border: "1px solid #ccc",
                  borderRadius: 5
                }}
            >
              <h3 style={{ textDecoration: task.completed ? "line-through" : "none" }}>
                {task.title}
              </h3>

              <p>{task.description}</p>

              <button onClick={() => toggleTask(task)}>
                {task.completed ? "Undo" : "Complete"}
              </button>

              <button onClick={() => deleteTask(task.id)}>
                Delete
              </button>
            </div>
        ))}
      </div>
  );
}

export default App;
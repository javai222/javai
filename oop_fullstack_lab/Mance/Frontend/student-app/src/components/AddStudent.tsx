import React, { useState } from 'react';
import { useQuery, useMutation, useQueryClient, keepPreviousData } from '@tanstack/react-query';
import { getStudents } from '../api/studentService';
import apiClient from '../api/axios'; // Make sure this matches your axios file location

// ==========================================
// 1. TYPE DEFINITIONS
// ==========================================
export interface Student {
    id: number;
    fullName: string;
    course: string;
}

// ==========================================
// 2. EXTRA API SERVICE METHOD
// ==========================================
// Added the create service right here so it stays in one code ecosystem
export const createStudent = async (newStudent: { fullName: string; course: string }): Promise<Student> => {
    try {
        const response = await apiClient.post('/api/student/create', null, {
            params: {
                fullName: newStudent.fullName,
                course: newStudent.course
            }
        });
        return response.data;
    } catch (error) {
        console.error('Error creating student:', error);
        throw error;
    }
};

// ==========================================
// 3. CUSTOM HOOKS
// ==========================================
export const useStudents = () => {
    const { data, isLoading, error, refetch, isFetching } = useQuery({
        queryKey: ['students'],
        queryFn: getStudents,
        placeholderData: keepPreviousData,
    });

    return {
        students: (data as Student[]) || [],
        isLoading,
        isFetching,
        error,
        refreshStudents: refetch,
    };
};

// ==========================================
// 4. MAIN INTEGRATED COMPONENT
// ==========================================
export const StudentList: React.FC = () => {
    const queryClient = useQueryClient();
    const { students, isLoading, isFetching, error, refreshStudents } = useStudents();
    
    // Form component states
    const [fullName, setFullName] = useState('');
    const [course, setCourse] = useState('');

    // Form mutation hook setup
    const mutation = useMutation({
        mutationFn: createStudent,
        onSuccess: () => {
            // Automatically tells the table hook above to grab fresh server data
            queryClient.invalidateQueries({ queryKey: ['students'] });
            setFullName('');
            setCourse('');
        }
    });

    const handleFormSubmit = (e: React.FormEvent) => {
        e.preventDefault();
        if (!fullName.trim() || !course.trim()) return;
        mutation.mutate({ fullName, course });
    };

    if (isLoading) return <div style={styles.center}>Initial load... Please wait.</div>;
    if (error) return <div style={{ ...styles.center, color: 'red' }}>Failed to load students. Ensure your backend is running.</div>;

    return (
        <div style={styles.container}>
            
            {/* SUB-FORM: ADD NEW STUDENT */}
            <div style={styles.formCard}>
                <h3 style={styles.formTitle}>Add New Student</h3>
                <form onSubmit={handleFormSubmit} style={styles.formLayout}>
                    <div style={styles.inputGroup}>
                        <label style={styles.label}>Full Name</label>
                        <input 
                            type="text" 
                            value={fullName}
                            onChange={(e) => setFullName(e.target.value)}
                            placeholder="John Doe"
                            style={styles.input}
                        />
                    </div>
                    <div style={styles.inputGroup}>
                        <label style={styles.label}>Course</label>
                        <input 
                            type="text" 
                            value={course}
                            onChange={(e) => setCourse(e.target.value)}
                            placeholder="BS Computer Science"
                            style={styles.input}
                        />
                    </div>
                    <button 
                        type="submit" 
                        disabled={mutation.isPending}
                        style={styles.addButton}
                    >
                        {mutation.isPending ? 'Saving...' : 'Add Student'}
                    </button>
                </form>
                {mutation.isError && <p style={styles.errorText}>Error: Could not save student.</p>}
                {mutation.isSuccess && <p style={styles.successText}>Student added safely!</p>}
            </div>

            {/* HEADER AND REFRESH BLOCK */}
            <div style={styles.header}>
                <h2 style={styles.title}>Student Directory</h2>
                <button 
                    onClick={() => refreshStudents()} 
                    disabled={isFetching}
                    style={{
                        ...styles.refreshButton,
                        opacity: isFetching ? 0.6 : 1,
                        cursor: isFetching ? 'not-allowed' : 'pointer'
                    }}
                >
                    {isFetching ? 'Refreshing...' : '🔄 Refresh List'}
                </button>
            </div>

            {/* DATA TABLE SECTION */}
            {students.length === 0 ? (
                <p style={styles.center}>No records found on server.</p>
            ) : (
                <table style={styles.table}>
                    <thead>
                        <tr style={styles.thRow}>
                            <th style={styles.th}>ID</th>
                            <th style={styles.th}>Full Name</th>
                            <th style={styles.th}>Course</th>
                        </tr>
                    </thead>
                    <tbody>
                        {students.map((student) => (
                            <tr key={student.id} style={styles.tr}>
                                <td style={styles.td}>{student.id}</td>
                                <td style={styles.td}>{student.fullName}</td>
                                <td style={styles.td}>{student.course}</td>
                            </tr>
                        ))}
                    </tbody>
                </table>
            )}
        </div>
    );
};

// ==========================================
// 5. EMBEDDED TYPED CSS STYLES
// ==========================================
const styles: Record<string, React.CSSProperties> = {
    container: { padding: '24px', maxWidth: '800px', margin: '0 auto', fontFamily: 'sans-serif' },
    formCard: { backgroundColor: '#f9f9fb', padding: '20px', borderRadius: '8px', border: '1px solid #e5e5e5', marginBottom: '32px' },
    formTitle: { margin: '0 0 16px 0', color: '#333', fontSize: '18px' },
    formLayout: { display: 'flex', gap: '16px', alignItems: 'flex-end', flexWrap: 'wrap' },
    inputGroup: { display: 'flex', flexDirection: 'column', gap: '6px', flex: '1', minWidth: '200px' },
    label: { fontSize: '13px', fontWeight: 'bold', color: '#555' },
    input: { padding: '10px', border: '1px solid #ccc', borderRadius: '6px', fontSize: '14px' },
    addButton: { padding: '11px 20px', backgroundColor: '#22c55e', color: '#fff', border: 'none', borderRadius: '6px', fontWeight: 'bold', cursor: 'pointer' },
    errorText: { color: 'red', marginTop: '10px', fontSize: '13px', margin: '8px 0 0 0' },
    successText: { color: 'green', marginTop: '10px', fontSize: '13px', margin: '8px 0 0 0' },
    header: { display: 'flex', justifyContent: 'space-between', alignItems: 'center', marginBottom: '20px' },
    title: { margin: 0, color: '#333' },
    refreshButton: { padding: '10px 16px', backgroundColor: '#0070f3', color: '#fff', border: 'none', borderRadius: '6px', fontWeight: 'bold' },
    table: { width: '100%', borderCollapse: 'collapse' },
    thRow: { backgroundColor: '#f5f5f7' },
    th: { padding: '12px', textAlign: 'left', borderBottom: '2px solid #e5e5e5', color: '#555' },
    tr: { borderBottom: '1px solid #e5e5e5' },
    td: { padding: '12px', color: '#333' },
    center: { textAlign: 'center', padding: '40px', fontSize: '16px' }
};
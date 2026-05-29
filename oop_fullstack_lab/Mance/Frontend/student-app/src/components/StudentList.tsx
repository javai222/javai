import React from 'react';
import { useQuery, keepPreviousData } from '@tanstack/react-query';
import { getStudents } from '../api/studentService';

export interface Student {
    id: number;
    fullName: string;
    course: string;
}

export const useStudents = () => {
    const { data, isLoading, error, refetch, isFetching } = useQuery({
        queryKey: ['students'],
        queryFn: getStudents,
        placeholderData: keepPreviousData,
    });

    return {
        students: data || [],
        isLoading,
        isFetching,
        error,
        refreshStudents: refetch,
    };
};

export const StudentList: React.FC = () => {
    const { students, isLoading, isFetching, error, refreshStudents } = useStudents();

    if (isLoading) return <div style={styles.center}>Initial load... Please wait.</div>;
    if (error) return <div style={{ ...styles.center, color: 'red' }}>Failed to load students.</div>;

    return (
        <div style={styles.container}>
            <div style={styles.header}>
                <h2 style={styles.title}>Student List</h2>
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

            {students.length === 0 ? (
                <p style={styles.center}>No students available.</p>
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

// 4. Fully Type-Safe Styling configuration
const styles: Record<string, React.CSSProperties> = {
    container: { padding: '24px', maxWidth: '800px', margin: '0 auto', fontFamily: 'sans-serif' },
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
import axios from 'axios';
import type {
	AxiosError,
	AxiosInstance,
	InternalAxiosRequestConfig,
} from 'axios';

const api: AxiosInstance = axios.create({
	baseURL: import.meta.env.VITE_API_BASE_URL ?? '/api',
	timeout: 15000,
	headers: {
		'Content-Type': 'application/json',
	},
});

api.interceptors.request.use(
	(config: InternalAxiosRequestConfig) => {
		const token = localStorage.getItem('token');

		if (token) {
			config.headers.Authorization = `Bearer ${token}`;
		}

		return config;
	},
	(error: AxiosError) => Promise.reject(error),
);

api.interceptors.response.use(
	(response) => response,
	(error: AxiosError) => Promise.reject(error),
);

export default api;

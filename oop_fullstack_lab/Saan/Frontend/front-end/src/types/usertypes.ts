export interface User {
  id: string;
  name: string;
  program: string;
  [key: string]: any;
}

export type { User as default }; 
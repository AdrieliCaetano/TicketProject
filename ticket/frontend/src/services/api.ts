const SERVER = 'http://localhost:8080'

const api = async <T>(endpoint: string, config?: RequestInit): Promise<T> => {
  console.log('Endpoint: ' + SERVER + endpoint);
  
  const result = await fetch(SERVER + endpoint, config);

  if (!result.ok) {
    throw new Error(`API Error: ${result.status} ${result.statusText}`);
  }
  return await result.json() as T;
}

export default api;
import api from "../services/api"
import type { IUser } from "../types/IUser"

export async function getAllUsers(): Promise<IUser[]> {
  return api<IUser[]>("/users")
}

export async function getUserById(id: string): Promise<IUser> {
  return api<IUser>(`/users/${id}`)
}




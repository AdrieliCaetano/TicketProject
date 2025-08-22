import api from "../services/api"
import type { ISale, ISaleCreate, ISaleRaw, ISaleUpdate } from "../types/ISale"
import { getUserById } from "./UserRepository";

export async function getAllSalesRaw(): Promise<ISaleRaw[]> {
  return api<ISaleRaw[]>("/sales")
}

export async function getAllSales(): Promise<ISale[]> {
    const sales = await getAllSalesRaw();

    const salesWithUsers = await Promise.all(
        sales.map(async sale => {
            const user = await getUserById(sale.user_id); 
            return { ...sale, user };
        })
    );

    return salesWithUsers;
}

export async function getSaleById(id: string): Promise<ISale> {
  return api<ISale>(`/sales/${id}`)
}

export async function createSale(sale: ISaleCreate): Promise<ISale> {
  return api<ISale>("/sales", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(sale),
  })
}

export async function updateSale(data: ISaleUpdate): Promise<ISale> {
    return api<ISale>('/sales', {
      method: "PUT",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(data),
    })
}

export async function deleteSale(id: string): Promise<ISale> {
  return api<ISale>("/sales/remove", {
    method: "DELETE",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({ id }),
  })
}

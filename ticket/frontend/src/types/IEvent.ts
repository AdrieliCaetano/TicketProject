export interface IEvent{
    id: string,
    description: string,
    type: string,
    date: string,
    startSales: string,
    endSales: string,
    price: number,
    createdAt?: string,
    updatedAt?: string
}

export type IEventCreate = Partial<Omit<IEvent, "id" | "createdAt" | "updatedAt">>;
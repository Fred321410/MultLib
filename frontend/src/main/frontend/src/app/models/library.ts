export class Library {
  constructor(
    public libraryName: string,
    public libraryDescription: string,
    public elements? : Element[],
    public libraryId?: number
  ){}
}

export interface Desmp3Plugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}

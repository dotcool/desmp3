export interface Desmp3Plugin {
  start(options: { value: string }): Promise<{ value: string }>;
  pause(options: { value: string }): Promise<{ value: string }>;
  echo(options: { value: string }): Promise<{ value: string }>;
}
